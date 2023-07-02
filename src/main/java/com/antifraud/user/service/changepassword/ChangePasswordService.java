package com.antifraud.user.service.changepassword;

import com.antifraud.user.AppUser;
import com.antifraud.user.repository.IAppUserRepository;
import com.antifraud.user.dtos.ChangePasswordDto;
import com.antifraud.security.PasswordConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangePasswordService implements IChangePasswordService {
    private final IAppUserRepository iAppUserRepository;
    private final PasswordConfig passwordConfig;

    public String changePassword(ChangePasswordDto changePasswordDto) {
        String userEmail =
                SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<AppUser> appUserByEmail =
                iAppUserRepository.findByEmail(userEmail);

        if (appUserByEmail.isEmpty()) {
            return "Something went wrong during your operation";
        }

        String oldPassHash = appUserByEmail.get().getPassword();

        boolean compareOld =
                passwordConfig.bCryptPasswordEncoder().matches(
                        changePasswordDto.oldPassword(),
                        oldPassHash
                );

        if (compareOld) {
            return "Provided old password is different than currently stored one";
        }

        boolean arePasswordsTheSame =
                passwordConfig.bCryptPasswordEncoder().matches(
                        changePasswordDto.newPassword(),
                        oldPassHash
                );

        if (arePasswordsTheSame) {
            return "New password cannot be the same as the old one!";
        }

        String encodedPassword = passwordConfig.bCryptPasswordEncoder().encode(
                changePasswordDto.newPassword());
        iAppUserRepository.changePassword(userEmail, encodedPassword);

        return "Changed password of the user with email: " + userEmail;
    }

}
