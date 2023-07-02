package com.antifraud.transfer.service;

import com.antifraud.transfer.Transfer;
import com.antifraud.transfer.dtos.CreateTransferDto;
import com.antifraud.transfer.dtos.TransferResponseDto;
import com.antifraud.transfer.dtos.TransferStatusResponseDto;
import com.antifraud.transfer.enums.Region;
import com.antifraud.transfer.mapper.TransferMapper;
import com.antifraud.transfer.repository.ITransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.antifraud.transfer.enums.RejectionReason.*;
import static com.antifraud.transfer.enums.TransferResult.*;

@Service
@RequiredArgsConstructor
public class TransferService implements ITransferService {
    private final ITransferRepository iTransferRepository;
    private final TransferMapper transferMapper;

    public TransferStatusResponseDto newTransfer(
            CreateTransferDto createTransferDto) {
        LocalDateTime hourBefore = LocalDateTime.now().minusHours(1);
        List<Transfer> transfers =
                iTransferRepository.findByDateAfter(hourBefore);

        long diffRegion = transfers.stream()
                .filter(transfer -> !transfer
                        .getRegion()
                        .equals(createTransferDto.region())
                )
                .count();
        long uniqueIp = transfers.stream()
                .filter(transfer -> !transfer
                        .getIp()
                        .equals(createTransferDto.ip())
                )
                .count();

        if (diffRegion > 2 && uniqueIp > 2) {
            return new TransferStatusResponseDto(
                    PROHIBITED.name(),
                    REGION_AND_IP_CORRELATION.getDescription()
            );
        } else if (diffRegion > 2) {
            return new TransferStatusResponseDto(
                    PROHIBITED.name(),
                    REGION_CORRELATION.getDescription()
            );
        } else if (uniqueIp > 2) {
            return new TransferStatusResponseDto(
                    PROHIBITED.name(),
                    IP_CORRELATION.getDescription()
            );
        } else if (diffRegion == 2) {
            return new TransferStatusResponseDto(
                    MANUAL_PROCESSING.name(),
                    REGION_CORRELATION.getDescription()
            );
        } else if (uniqueIp == 2) {
            return new TransferStatusResponseDto(
                    MANUAL_PROCESSING.name(),
                    IP_CORRELATION.getDescription()
            );
        }

        if (!isRegionValid(createTransferDto.region())) {
            return new TransferStatusResponseDto(
                    PROHIBITED.name(),
                    REGION.getDescription()
            );
        }

        Transfer transfer = transferMapper.toTransfer(createTransferDto);

        iTransferRepository.saveAndFlush(transfer);

        return new TransferStatusResponseDto(
                ALLOWED.name(),
                NONE.getDescription()
        );
    }

    private boolean isRegionValid(String inputRegion) {
        return Arrays.stream(Region.values())
                .anyMatch(region -> region.name().equals(inputRegion));
    }

    public List<TransferResponseDto> getAllTransfers() {
        List<Transfer> allTransfers = iTransferRepository.findAll();

        return allTransfers.stream()
                .map(transferMapper::toTransferResponseDto)
                .collect(Collectors.toList()
                );
    }

}
