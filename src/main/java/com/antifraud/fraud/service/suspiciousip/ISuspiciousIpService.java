package com.antifraud.fraud.service.suspiciousip;

import com.antifraud.fraud.dtos.CreateSuspiciousIpDto;
import com.antifraud.fraud.dtos.SuspiciousIpResponseDto;
import com.antifraud.fraud.SuspiciousIp;

import java.util.List;

public interface ISuspiciousIpService {
    SuspiciousIpResponseDto addSuspiciousIp(CreateSuspiciousIpDto createSuspiciousIpDto);
    List<SuspiciousIp> allSuspiciousIps();
    String deleteSuspiciousIp(Long id);

}
