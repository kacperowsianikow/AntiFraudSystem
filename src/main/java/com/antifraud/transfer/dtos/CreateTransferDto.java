package com.antifraud.transfer.dtos;

import com.antifraud.fraud.ips.ValidIPv4;
import com.antifraud.transfer.amount.ValidAmount;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.LuhnCheck;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record CreateTransferDto(@ValidAmount
                                Long amount,
                                @NotBlank(message = "Field 'ip' cannot be empty")
                                @ValidIPv4
                                String ip,
                                @NotBlank(message = "Field 'cardNumber' cannot be empty")
                                @LuhnCheck
                                String cardNumber,
                                @NotBlank(message = "Field 'region' cannot be empty")
                                String region,
                                @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                LocalDateTime date) {

}
