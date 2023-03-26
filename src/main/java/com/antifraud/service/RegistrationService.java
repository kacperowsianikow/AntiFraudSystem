package com.antifraud.service;

import com.antifraud.appuser.AppUser;
import com.antifraud.appuser.AppUserRole;
import com.antifraud.repository.IAppUserRepository;
import com.antifraud.registration.RegistrationRequest;
import com.antifraud.response.RegistrationResponse;
import com.antifraud.registration.email.IEmailSender;
import com.antifraud.registration.token.ConfirmationToken;
import com.antifraud.security.PasswordConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static com.antifraud.registration.email.EmailTemplate.createEmail;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final IAppUserRepository iAppUserRepository;
    private final IEmailSender iEmailSender;
    private final ConfirmationTokenService confirmationTokenService;
    private final PasswordConfig passwordConfig;
    @SuppressWarnings("FieldCanBeLocal")
    private final String CONFIRMATION_LINK =
            "http://localhost:8080/api/antifraud/signup/confirm?token=";
    @SuppressWarnings("FieldCanBeLocal")
    private final int EXPIRATION_TIME = 15;

    public RegistrationResponse registerAppUser(RegistrationRequest registrationRequest) {
        Optional<AppUser> appUserByEmail =
                iAppUserRepository.findByEmail(registrationRequest.email());

        if (appUserByEmail.isEmpty()) {
            String encodedPassword =
                    passwordConfig.bCryptPasswordEncoder().encode(registrationRequest.password());

            AppUser appUser = new AppUser(
                    registrationRequest.firstname(),
                    registrationRequest.lastname(),
                    registrationRequest.email(),
                    encodedPassword
            );

            if (iAppUserRepository.findAll().isEmpty()) {
                appUser.setAppUserRoles(
                        Collections.singletonList(AppUserRole.ROLE_ADMIN)
                );
                appUser.setIsAccountNonLocked(true);
            }
            else {
                appUser.setAppUserRoles(
                        Collections.singletonList(AppUserRole.ROLE_MERCHANT)
                );
            }

            iAppUserRepository.save(appUser);

            String token = generateToken(appUser);

            String link = CONFIRMATION_LINK + token;

            iEmailSender.send(
                    registrationRequest.email(),
                    createEmail(registrationRequest.firstname(), link)
            );

            return new RegistrationResponse(
                    appUser.getId(),
                    appUser.getFirstname(),
                    appUser.getLastname(),
                    appUser.getEmail(),
                    appUser.getAppUserRoles()
            );
        }

        ConfirmationToken confirmationToken = confirmationTokenService
                .getTokenByAppUserId(appUserByEmail.get().getId())
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmedAt() == null) {
            String token = updateToken(appUserByEmail.get().getId());

            String link = CONFIRMATION_LINK + token;

            iEmailSender.send(
                    registrationRequest.email(),
                    createEmail(registrationRequest.firstname(), link)
            );

            return new RegistrationResponse(
                    appUserByEmail.get().getId(),
                    appUserByEmail.get().getFirstname(),
                    appUserByEmail.get().getLastname(),
                    appUserByEmail.get().getEmail(),
                    appUserByEmail.get().getAppUserRoles()
            );
        }

        return new RegistrationResponse(
                appUserByEmail.get().getId(),
                appUserByEmail.get().getFirstname(),
                appUserByEmail.get().getLastname(),
                appUserByEmail.get().getEmail(),
                appUserByEmail.get().getAppUserRoles()
        );
    }

    private String updateToken(Long id) {
        String generatedToken = UUID.randomUUID().toString();

        confirmationTokenService.updateToken(
                id,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(EXPIRATION_TIME),
                generatedToken
        );

        return generatedToken;
    }

    private String generateToken(AppUser appUser) {
        String generatedToken = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                generatedToken,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(EXPIRATION_TIME),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return generatedToken;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            return "email already confirmed";
        }

        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            return "validation link has expired";
        }

        confirmationTokenService.setConfirmedAt(token);

        iAppUserRepository.enableAppUser(
                confirmationToken.getAppUser().getEmail()
        );

        return "email confirmed successfully";
    }

}
