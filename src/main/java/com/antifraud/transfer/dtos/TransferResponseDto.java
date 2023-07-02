package com.antifraud.transfer.dtos;

import java.time.LocalDateTime;

public record TransferResponseDto(Long id,
                                  Long amount,
                                  String ip,
                                  String cardNumber,
                                  String region,
                                  LocalDateTime date) {

}
