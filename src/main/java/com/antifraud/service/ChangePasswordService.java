package com.antifraud.service;

import com.antifraud.appuser.AppUser;
import com.antifraud.repository.IAppUserRepository;
import com.antifraud.changepassword.ChangePasswordRequest;
import com.antifraud.security.PasswordConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {
    private final IAppUserRepository iAppUserRepository;
    private final PasswordConfig passwordConfig;

    public String changePassword(ChangePasswordRequest changePasswordRequest) {
        String userEmail =
                SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<AppUser> appUserByEmail =
                iAppUserRepository.findByEmail(userEmail);

        if (appUserByEmail.isEmpty()) {
            return "Something went wrong during your operation";
        }

        String oldPassHash = appUserByEmail.get().getPassword();

        //compare oldPassword from request with password stored in the database
        boolean compareOld =
                passwordConfig.bCryptPasswordEncoder().matches(
                        changePasswordRequest.oldPassword(),
                        oldPassHash
                );

        if (compareOld) {
            return "Provided old password is different than currently stored one";
        }

        boolean arePasswordsTheSame =
                passwordConfig.bCryptPasswordEncoder().matches(
                        changePasswordRequest.newPassword(),
                        oldPassHash
                );

        if (arePasswordsTheSame) {
            return "New password cannot be the same as the old one!";
        }

        String encodedPassword = passwordConfig.bCryptPasswordEncoder().encode(
                changePasswordRequest.newPassword());
        iAppUserRepository.changePassword(userEmail, encodedPassword);

        return "Changed password of the user with email: " + userEmail;
    }

}
