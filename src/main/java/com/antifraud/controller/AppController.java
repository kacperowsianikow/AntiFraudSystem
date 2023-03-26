package com.antifraud.controller;

import com.antifraud.alterRole.AlterRoleRequest;
import com.antifraud.changepassword.ChangePasswordRequest;
import com.antifraud.ips.SuspiciousIp;
import com.antifraud.ips.SuspiciousIpRequest;
import com.antifraud.registration.RegistrationRequest;
import com.antifraud.response.AppUserResponse;
import com.antifraud.response.RegistrationResponse;
import com.antifraud.response.TransferResponse;
import com.antifraud.service.AppService;
import com.antifraud.service.ChangePasswordService;
import com.antifraud.service.RegistrationService;
import com.antifraud.service.TransferService;
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
    private final AppService appService;
    private final TransferService transferService;
    private final RegistrationService registrationService;
    private final ChangePasswordService changePasswordService;

    @PostMapping("/merchant/transaction")
    public TransferResponse newTransfer(@Valid @RequestBody TransferRequest transferRequest) {
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
    public SuspiciousIp suspiciousIp(@Valid @RequestBody SuspiciousIpRequest suspiciousIpRequest) {
        return appService.addSuspiciousIp(suspiciousIpRequest);
    }

    @PostMapping("/support/stolencard")
    public StolenCard stolenCard(@Valid @RequestBody StolenCardRequest stolenCardRequest) {
        return appService.addStolenCard(stolenCardRequest);
    }

    @PutMapping("/admin/access")
    public String unlockAppUser(@RequestBody UnlockAppUser unlockAppUser) {
        return appService.unlockAppUser(unlockAppUser);
    }

    @PutMapping("/admin/role")
    public String alterRole(@RequestBody AlterRoleRequest alterRole) {
        return appService.alterRole(alterRole);
    }

    @GetMapping("/signup/confirm")
    public String confirmToken(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping("/listusers")
    public List<AppUserResponse> appUser() {
        return appService.getAppUsers();
    }

    @GetMapping("/support/suspicious-ip")
    public List<SuspiciousIp> suspiciousIps() {
        return appService.allSuspiciousIps();
    }

    @GetMapping("/support/stolencard")
    public List<StolenCard> stolenCards() {
        return appService.allStolenCards();
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return appService.deleteUser(id);
    }

    @DeleteMapping("/support/suspicious-ip/{id}")
    public String deleteSuspiciousIp(@PathVariable("id") Long id) {
        return appService.deleteSuspiciousIp(id);
    }

    @DeleteMapping("/support/stolencard/{id}")
    public String deleteStolenCard(@PathVariable("id") Long id) {
        return appService.deleteStolenCard(id);
    }

}
