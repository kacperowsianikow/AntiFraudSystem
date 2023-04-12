package com.antifraud.controller;

import com.antifraud.alterRole.AlterRoleRequest;
import com.antifraud.changepassword.ChangePasswordRequest;
import com.antifraud.ips.SuspiciousIp;
import com.antifraud.ips.SuspiciousIpRequest;
import com.antifraud.registration.RegistrationRequest;
import com.antifraud.response.*;
import com.antifraud.service.*;
import com.antifraud.stolencard.StolenCard;
import com.antifraud.stolencard.StolenCardRequest;
import com.antifraud.transfer.TransferRequest;
import com.antifraud.unlock.UnlockAppUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antifraud")
@RequiredArgsConstructor
public class AppController {
    private final AppUserService appUserService;
    private final SuspiciousIpService suspiciousIpService;
    private final StolenCardService stolenCardService;
    private final TransferService transferService;
    private final RegistrationService registrationService;
    private final ChangePasswordService changePasswordService;

    @PostMapping("/merchant/transaction")
    public TransferStatus newTransfer(@Valid @RequestBody TransferRequest transferRequest) {
        return transferService.newTransfer(transferRequest);
    }

    @PostMapping("/signup")
    public RegistrationResponse register(@Valid @RequestBody RegistrationRequest registrationRequest) {
        return registrationService.registerAppUser(registrationRequest);
    }

    @PostMapping("/changepassword")
    public String changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        return changePasswordService.changePassword(changePasswordRequest);
    }

    @PostMapping("/support/suspicious-ip")
    public SuspiciousIpResponse suspiciousIp(@Valid @RequestBody SuspiciousIpRequest suspiciousIpRequest) {
        return suspiciousIpService.addSuspiciousIp(suspiciousIpRequest);
    }

    @PostMapping("/support/stolencard")
    public StolenCardResponse stolenCard(@Valid @RequestBody StolenCardRequest stolenCardRequest) {
        return stolenCardService.addStolenCard(stolenCardRequest);
    }

    @PutMapping("/admin/access")
    public String unlockAppUser(@RequestBody UnlockAppUser unlockAppUser) {
        return appUserService.unlockAppUser(unlockAppUser);
    }

    @PutMapping("/admin/role")
    public String alterRole(@RequestBody AlterRoleRequest alterRole) {
        return appUserService.alterRole(alterRole);
    }

    @GetMapping("/signup/confirm")
    public String confirmToken(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping("/list-users")
    public List<AppUserResponse> appUsers() {
        return appUserService.getAppUsers();
    }

    @GetMapping("/support/list-transactions")
    public List<TransferResponse> transfers() {
        return transferService.getAllTransfers();
    }

    @GetMapping("/support/suspicious-ip")
    public List<SuspiciousIp> suspiciousIps() {
        return suspiciousIpService.allSuspiciousIps();
    }

    @GetMapping("/support/stolencard")
    public List<StolenCard> stolenCards() {
        return stolenCardService.allStolenCards();
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return appUserService.deleteUser(id);
    }

    @DeleteMapping("/support/suspicious-ip/{id}")
    public String deleteSuspiciousIp(@PathVariable("id") Long id) {
        return suspiciousIpService.deleteSuspiciousIp(id);
    }

    @DeleteMapping("/support/stolencard/{id}")
    public String deleteStolenCard(@PathVariable("id") Long id) {
        return stolenCardService.deleteStolenCard(id);
    }

}
