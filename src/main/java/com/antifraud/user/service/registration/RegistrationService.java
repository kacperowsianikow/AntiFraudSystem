package com.antifraud.user.service.registration;

import com.antifraud.user.AppUser;
import com.antifraud.user.enums.AppUserRole;
import com.antifraud.user.mapper.AppUserMapper;
import com.antifraud.user.repository.IAppUserRepository;
import com.antifraud.user.dtos.CreateAppUserDto;
import com.antifraud.user.dtos.AppUserRegistrationResponseDto;
import com.antifraud.user.email.IEmailSender;
import com.antifraud.user.ConfirmationToken;
import com.antifraud.security.PasswordConfig;
import com.antifraud.user.service.confirmationtoken.IConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static com.antifraud.user.email.EmailTemplate.createEmail;

@Service
@RequiredArgsConstructor
public class RegistrationService implements IRegistrationService {
    private final IAppUserRepository iAppUserRepository;
    private final IEmailSender iEmailSender;
    private final IConfirmationTokenService iConfirmationTokenService;
    private final AppUserMapper appUserMapper;
    private final PasswordConfig passwordConfig;
    @SuppressWarnings("FieldCanBeLocal")
    private final String CONFIRMATION_LINK =
            "http://localhost:8080/api/antifraud/signup/confirm?token=";
    @SuppressWarnings("FieldCanBeLocal")
    private final int EXPIRATION_TIME = 15;

    public AppUserRegistrationResponseDto registerAppUser(CreateAppUserDto createAppUserDto) {
        Optional<AppUser> appUserByEmail =
                iAppUserRepository.findByEmail(createAppUserDto.email());

        if (appUserByEmail.isEmpty()) {
            AppUser appUser = appUserMapper.toAppUser(createAppUserDto);
            appUser.setPassword(passwordConfig
                    .bCryptPasswordEncoder()
                    .encode(createAppUserDto.password()));

            if (iAppUserRepository.findAll().isEmpty()) {
                appUser.setAppUserRoles(
                        Collections.singletonList(AppUserRole.ROLE_ADMIN)
                );
                appUser.setIsAccountNonLocked(true);
            }

            appUser.setAppUserRoles(
                    Collections.singletonList(AppUserRole.ROLE_MERCHANT)
            );

            iAppUserRepository.saveAndFlush(appUser);

            String token = generateToken(appUser);

            String link = CONFIRMATION_LINK + token;

            iEmailSender.send(
                    createAppUserDto.email(),
                    createEmail(createAppUserDto.firstname(), link)
            );

            return appUserMapper.toAppUserRegistrationResponseDto(appUser);
        }
        AppUser existingAppUser = appUserByEmail.orElseThrow(
                () -> new IllegalStateException("User not found")
        );

        ConfirmationToken confirmationToken = iConfirmationTokenService
                .getTokenByAppUserId(appUserByEmail.get().getId())
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmedAt() == null) {
            String token = updateToken(appUserByEmail.get().getId());

            String link = CONFIRMATION_LINK + token;

            iEmailSender.send(
                    createAppUserDto.email(),
                    createEmail(createAppUserDto.firstname(), link)
            );

            return appUserMapper.toAppUserRegistrationResponseDto(existingAppUser);
        }

        return appUserMapper.toAppUserRegistrationResponseDto(existingAppUser);
    }

    private String updateToken(Long id) {
        String generatedToken = UUID.randomUUID().toString();

        iConfirmationTokenService.updateToken(
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

        iConfirmationTokenService.saveConfirmationToken(confirmationToken);

        return generatedToken;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = iConfirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            return "email already confirmed";
        }

        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            return "validation link has expired";
        }

        iConfirmationTokenService.setConfirmedAt(token);

        iAppUserRepository.enableAppUser(
                confirmationToken.getAppUser().getEmail()
        );

        return "email confirmed successfully";
    }

}
