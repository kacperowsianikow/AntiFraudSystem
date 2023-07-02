package com.antifraud.controller;


import com.antifraud.fraud.StolenCard;
import com.antifraud.fraud.SuspiciousIp;
import com.antifraud.fraud.dtos.CreateStolenCardDto;
import com.antifraud.fraud.dtos.CreateSuspiciousIpDto;
import com.antifraud.fraud.dtos.StolenCardResponseDto;
import com.antifraud.fraud.dtos.SuspiciousIpResponseDto;
import com.antifraud.fraud.service.stolencard.IStolenCardService;
import com.antifraud.fraud.service.suspiciousip.ISuspiciousIpService;
import com.antifraud.transfer.dtos.CreateTransferDto;
import com.antifraud.transfer.dtos.TransferResponseDto;
import com.antifraud.transfer.dtos.TransferStatusResponseDto;
import com.antifraud.transfer.service.ITransferService;
import com.antifraud.user.dtos.*;
import com.antifraud.user.service.appuser.IAppUserService;
import com.antifraud.user.service.changepassword.IChangePasswordService;
import com.antifraud.user.service.registration.IRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antifraud")
@RequiredArgsConstructor
public class AppController {
    private final ISuspiciousIpService iSuspiciousIpService;
    private final IStolenCardService iStolenCardService;
    private final ITransferService iTransferService;
    private final IRegistrationService iRegistrationService;
    private final IChangePasswordService iChangePasswordService;
    private final IAppUserService iAppUserService;

    @GetMapping("/signup/confirm")
    public String confirmToken(@RequestParam("token") String token) {
        return iRegistrationService.confirmToken(token);
    }

    @GetMapping("/list-users")
    public List<AppUserResponseDto> appUsers() {
        return iAppUserService.getAppUsers();
    }

    @GetMapping("/support/list-transactions")
    public List<TransferResponseDto> transfers() {
        return iTransferService.getAllTransfers();
    }

    @GetMapping("/support/suspicious-ip")
    public List<SuspiciousIp> suspiciousIps() {
        return iSuspiciousIpService.allSuspiciousIps();
    }

    @GetMapping("/support/stolencard")
    public List<StolenCard> stolenCards() {
        return iStolenCardService.allStolenCards();
    }

    @PostMapping("/signup")
    public AppUserRegistrationResponseDto register(
            @Valid @RequestBody CreateAppUserDto createAppUserDto) {
        return iRegistrationService.registerAppUser(createAppUserDto);
    }

    @PostMapping("/changepassword")
    public String changePassword(
            @Valid @RequestBody ChangePasswordDto changePasswordDto) {
        return iChangePasswordService.changePassword(changePasswordDto);
    }

    @PostMapping("/merchant/transaction")
    public TransferStatusResponseDto newTransfer(
            @Valid @RequestBody CreateTransferDto createTransferDto) {
        return iTransferService.newTransfer(createTransferDto);
    }

    @PostMapping("/support/suspicious-ip")
    public SuspiciousIpResponseDto suspiciousIp(
            @Valid @RequestBody CreateSuspiciousIpDto createSuspiciousIpDto) {
        return iSuspiciousIpService.addSuspiciousIp(createSuspiciousIpDto);
    }

    @PostMapping("/support/stolencard")
    public StolenCardResponseDto stolenCard(
            @Valid @RequestBody CreateStolenCardDto createStolenCardDto) {
        return iStolenCardService.addStolenCard(createStolenCardDto);
    }

    @PutMapping("/admin/access")
    public String unlockAppUser(
            @RequestBody UnlockAppUserDto unlockAppUserDto) {
        return iAppUserService.unlockAppUser(unlockAppUserDto);
    }

    @PutMapping("/admin/role")
    public String alterRole(@RequestBody AlterRoleDto alterRole) {
        return iAppUserService.alterRole(alterRole);
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return iAppUserService.deleteUser(id);
    }

    @DeleteMapping("/support/suspicious-ip/{id}")
    public String deleteSuspiciousIp(@PathVariable("id") Long id) {
        return iSuspiciousIpService.deleteSuspiciousIp(id);
    }

    @DeleteMapping("/support/stolencard/{id}")
    public String deleteStolenCard(@PathVariable("id") Long id) {
        return iStolenCardService.deleteStolenCard(id);
    }

}
