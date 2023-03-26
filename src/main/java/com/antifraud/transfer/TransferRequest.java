package com.antifraud.transfer;

import com.antifraud.ips.ValidIPv4;
import com.antifraud.transfer.amount.ValidAmount;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.LuhnCheck;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record TransferRequest(@ValidAmount
                              Long amount,
                              @ValidIPv4
                              String ip,
                              @LuhnCheck
                              String cardNumber,
                              String region,
                              @NotBlank(message = "Field 'date' cannot be empty")
                              @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                              LocalDateTime date) {

}
