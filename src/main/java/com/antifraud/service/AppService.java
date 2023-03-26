package com.antifraud.service;

import com.antifraud.alterRole.AlterRoleRequest;
import com.antifraud.appuser.AppUser;
import com.antifraud.ips.SuspiciousIp;
import com.antifraud.ips.SuspiciousIpRequest;
import com.antifraud.repository.*;
import com.antifraud.response.AppUserResponse;
import com.antifraud.response.TransferResponse;
import com.antifraud.stolencard.StolenCard;
import com.antifraud.stolencard.StolenCardRequest;
import com.antifraud.transfer.*;
import com.antifraud.transfer.Region;
import com.antifraud.unlock.UnlockAppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppService {
    private final IAppUserRepository iAppUserRepository;
    private final ISuspiciousIpRepository iSuspiciousIpRepository;
    private final IStolenCardRepository iStolenCardRepository;
    private final IConfirmationTokenRepository iConfirmationTokenRepository;

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

    public SuspiciousIp addSuspiciousIp(SuspiciousIpRequest suspiciousIpRequest) {
        Optional<SuspiciousIp> suspiciousIp =
                iSuspiciousIpRepository.findByIp(suspiciousIpRequest.ip());

        if (suspiciousIp.isPresent()) {
            throw new IllegalStateException(
                    "Provided IP address is already in the database"
            );
        }

        SuspiciousIp newSuspiciousIp = new SuspiciousIp(
                suspiciousIpRequest.ip()
        );

        iSuspiciousIpRepository.save(newSuspiciousIp);

        return newSuspiciousIp;
    }

    public StolenCard addStolenCard(StolenCardRequest stolenCardRequest) {
        Optional<StolenCard> stolenCard =
                iStolenCardRepository.findByCardNumber(stolenCardRequest.cardNumber());

        if (stolenCard.isPresent()) {
            throw new IllegalStateException(
                    "Card with provided number is already in the database"
            );
        }

        StolenCard newStolenCard = new StolenCard(
                stolenCardRequest.cardNumber()
        );

        iStolenCardRepository.save(newStolenCard);

        return newStolenCard;
    }

    public List<SuspiciousIp> allSuspiciousIps() {
        return iSuspiciousIpRepository.findAll();
    }

    public List<StolenCard> allStolenCards() {
        return iStolenCardRepository.findAll();
    }

    public String deleteSuspiciousIp(Long id) {
        SuspiciousIp suspiciousIp = iSuspiciousIpRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "There is no IP address with id: " + id
                ));

        iSuspiciousIpRepository.delete(suspiciousIp);

        return "Successfully deleted IP address: " + suspiciousIp.getIp();
    }

    public String deleteStolenCard(Long id) {
        StolenCard stolenCard = iStolenCardRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "There is no card with id: " + id
                ));

        iStolenCardRepository.delete(stolenCard);

        return "Successfully deleted stolen card with number: " + stolenCard.getCardNumber();
    }

}
