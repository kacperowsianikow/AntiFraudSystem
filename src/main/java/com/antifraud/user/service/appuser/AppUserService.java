package com.antifraud.user.service.appuser;

import com.antifraud.user.AppUser;
import com.antifraud.user.dtos.AlterRoleDto;
import com.antifraud.user.dtos.AppUserResponseDto;
import com.antifraud.user.dtos.UnlockAppUserDto;
import com.antifraud.user.mapper.AppUserMapper;
import com.antifraud.user.repository.IAppUserRepository;
import com.antifraud.user.repository.IConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserService implements IAppUserService {
    private final IAppUserRepository iAppUserRepository;
    private final IConfirmationTokenRepository iConfirmationTokenRepository;
    private final AppUserMapper appUserMapper;

    public String unlockAppUser(UnlockAppUserDto unlockAppUserDto) {
        Optional<AppUser> appUser =
                iAppUserRepository.findByEmail(unlockAppUserDto.email());

        if (appUser.isPresent()) {
            iAppUserRepository.unlockAppUser(
                    unlockAppUserDto.email(),
                    unlockAppUserDto.isAccountNonLocked()
            );

            return "App user's account with email " +
                    unlockAppUserDto.email() + " is now unlocked";
        }

        return "There is no account with email: " + unlockAppUserDto.email();
    }

    public String alterRole(AlterRoleDto alterRoleDto) {
        Optional<AppUser> appUser =
                iAppUserRepository.findByEmail(alterRoleDto.email());

        if (appUser.isPresent()) {
            iAppUserRepository.updateAppUserRolesByEmail(
                    alterRoleDto.roles(),
                    alterRoleDto.email()
            );

            return "Successfully altered roles of user: " + alterRoleDto.email() +
                    ", to: " + alterRoleDto.roles();
        }

        return "There is no user with email: " + alterRoleDto.email();
    }

    public List<AppUserResponseDto> getAppUsers() {
        List<AppUser> allAppUsers = iAppUserRepository.findAll();

        return allAppUsers.stream()
                .map(appUserMapper::toAppUserResponseDto)
                .collect(Collectors.toList());
    }

    public String deleteUser(Long id) {
        AppUser appUser = iAppUserRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "There is no user with id: " + id
                ));

        iConfirmationTokenRepository.deleteByAppUser(appUser);
        iAppUserRepository.delete(appUser);

        return "Successfully deleted user with id: " + id +
                " and email: " + appUser.getEmail();
    }
}
