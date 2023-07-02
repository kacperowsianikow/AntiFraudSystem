package com.antifraud.fraud.mapper;

import com.antifraud.fraud.dtos.CreateStolenCardDto;
import com.antifraud.fraud.dtos.CreateSuspiciousIpDto;
import com.antifraud.fraud.dtos.StolenCardResponseDto;
import com.antifraud.fraud.dtos.SuspiciousIpResponseDto;
import com.antifraud.fraud.SuspiciousIp;
import com.antifraud.fraud.StolenCard;
import org.springframework.stereotype.Component;

@Component
public class FraudMapper {

    public StolenCard toStolenCard(CreateStolenCardDto createStolenCardDto) {
        return new StolenCard(
                createStolenCardDto.cardNumber()
        );
    }

    public StolenCardResponseDto toStolenCardResponseDto(StolenCard stolenCard) {
        return new StolenCardResponseDto(
                stolenCard.getId(),
                stolenCard.getCardNumber()
        );
    }

    public SuspiciousIp toSuspiciousIp(CreateSuspiciousIpDto createSuspiciousIpDto) {
        return new SuspiciousIp(
                createSuspiciousIpDto.ip()
        );
    }

    public SuspiciousIpResponseDto toSuspiciousIpResponseDto(SuspiciousIp suspiciousIp) {
        return new SuspiciousIpResponseDto(
                suspiciousIp.getId(),
                suspiciousIp.getIp()
        );
    }

}
