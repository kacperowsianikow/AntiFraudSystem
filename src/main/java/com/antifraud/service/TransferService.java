package com.antifraud.service;

import com.antifraud.repository.ITransferRepository;
import com.antifraud.response.TransferResponse;
import com.antifraud.transfer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final ITransferRepository iTransferRepository;

    public TransferResponse newTransfer(TransferRequest transferRequest) {
        LocalDateTime hourBefore = LocalDateTime.now().minusHours(1);
        List<Transfer> transfers =
                iTransferRepository.findByDateAfter(hourBefore);

        int diffRegion = 0;
        int uniqueIp = 0;
        for (Transfer transfer : transfers) {
            if (!transfer.getRegion().equals(transferRequest.region())) {
                diffRegion++;
            }

            if (!transfer.getIp().equals(transferRequest.ip())) {
                uniqueIp++;
            }

            if (diffRegion > 2 || uniqueIp > 2) {
                break;
            }
        }

        if (diffRegion > 2 && uniqueIp > 2) {
            return new TransferResponse(
                    TransferResult.PROHIBITED.name(),
                    RejectionReason.REGION_AND_IP_CORRELATION.getDescription()
            );
        } else if (diffRegion > 2) {
            return new TransferResponse(
                    TransferResult.PROHIBITED.name(),
                    RejectionReason.REGION_CORRELATION.getDescription()
            );
        } else if (uniqueIp > 2) {
            return new TransferResponse(
                    TransferResult.PROHIBITED.name(),
                    RejectionReason.IP_CORRELATION.getDescription()
            );
        } else if (diffRegion == 2) {
            return new TransferResponse(
                    TransferResult.MANUAL_PROCESSING.name(),
                    RejectionReason.REGION_CORRELATION.getDescription()
            );
        } else if (uniqueIp == 2) {
            return new TransferResponse(
                    TransferResult.MANUAL_PROCESSING.name(),
                    RejectionReason.IP_CORRELATION.getDescription()
            );
        }

        if (!isRegionValid(transferRequest.region())) {
            return new TransferResponse(
                    TransferResult.PROHIBITED.name(),
                    RejectionReason.REGION.getDescription()
            );
        }

        Transfer transfer = new Transfer(
                transferRequest.amount(),
                transferRequest.ip(),
                transferRequest.cardNumber(),
                transferRequest.region(),
                transferRequest.date()
        );

        iTransferRepository.save(transfer);

        return new TransferResponse(
                TransferResult.ALLOWED.name(),
                RejectionReason.NONE.getDescription()
        );
    }

    private boolean isRegionValid(String inputRegion) {
        return Arrays.stream(Region.values())
                .anyMatch(region -> region.name().equals(inputRegion));
    }

}
