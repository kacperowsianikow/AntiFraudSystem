package com.antifraud.service;

import com.antifraud.alterRole.AlterRoleRequest;
import com.antifraud.appuser.AppUser;
import com.antifraud.repository.IAppUserRepository;
import com.antifraud.repository.IConfirmationTokenRepository;
import com.antifraud.response.AppUserResponse;
import com.antifraud.unlock.UnlockAppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
    private final IAppUserRepository iAppUserRepository;
    private final IConfirmationTokenRepository iConfirmationTokenRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return iAppUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with email: " + email + ", was not found"
                ));
    }

    public String unlockAppUser(UnlockAppUser unlockAppUser) {
        Optional<AppUser> appUser =
                iAppUserRepository.findByEmail(unlockAppUser.email());

        if (appUser.isPresent()) {
            iAppUserRepository.unlockAppUser(
                    unlockAppUser.email(),
                    unlockAppUser.isAccountNonLocked());

            return "App user's account with email " +
                    unlockAppUser.email() + " is now unlocked";
        }

        return "There is no account with email: " + unlockAppUser.email();
    }

    public String alterRole(AlterRoleRequest alterRoleRequest) {
        Optional<AppUser> appUser =
                iAppUserRepository.findByEmail(alterRoleRequest.email());

        if (appUser.isPresent()) {
            iAppUserRepository.updateAppUserRolesByEmail(
                    alterRoleRequest.roles(),
                    alterRoleRequest.email()
            );

            return "Successfully altered roles of user: " + alterRoleRequest.email() +
                    ", to: " + alterRoleRequest.roles();
        }

        return "There is no user with email: " + alterRoleRequest.email();
    }

    public List<AppUserResponse> getAppUsers() {
        List<AppUser> allAppUsers = iAppUserRepository.findAll();
        List<AppUserResponse> appUsersResponse = new LinkedList<>();

        for (AppUser appUser : allAppUsers) {
            AppUserResponse response = new AppUserResponse(
                    appUser.getId(),
                    appUser.getEmail(),
                    appUser.getAppUserRoles(),
                    appUser.getIsAccountNonLocked()
            );
            appUsersResponse.add(response);
        }

        return appUsersResponse;
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
