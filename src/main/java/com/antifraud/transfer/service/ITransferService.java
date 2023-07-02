package com.antifraud.transfer.service;

import com.antifraud.transfer.dtos.CreateTransferDto;
import com.antifraud.transfer.dtos.TransferResponseDto;
import com.antifraud.transfer.dtos.TransferStatusResponseDto;

import java.util.List;

public interface ITransferService {
    TransferStatusResponseDto newTransfer(CreateTransferDto createTransferDto);
    public List<TransferResponseDto> getAllTransfers();

}
