package com.antifraud.transfer.mapper;

import com.antifraud.transfer.Transfer;
import com.antifraud.transfer.dtos.CreateTransferDto;
import com.antifraud.transfer.dtos.TransferResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {

    public Transfer toTransfer(CreateTransferDto createTransferDto) {
        return new Transfer(
                createTransferDto.amount(),
                createTransferDto.ip(),
                createTransferDto.cardNumber(),
                createTransferDto.region(),
                createTransferDto.date()
        );
    }

    public TransferResponseDto toTransferResponseDto(Transfer transfer) {
        return new TransferResponseDto(
                transfer.getId(),
                transfer.getAmount(),
                transfer.getIp(),
                transfer.getCardNumber(),
                transfer.getRegion(),
                transfer.getDate()
        );
    }

}
