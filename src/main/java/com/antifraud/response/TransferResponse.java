package com.antifraud.response;

import java.time.LocalDateTime;

public record TransferResponse(Long id,
                               Long amount,
                               String ip,
                               String cardNumber,
                               String region,
                               LocalDateTime date) {

}
