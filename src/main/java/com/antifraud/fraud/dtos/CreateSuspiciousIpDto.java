package com.antifraud.fraud.dtos;

import com.antifraud.fraud.ips.ValidIPv4;
import jakarta.validation.constraints.NotBlank;

public record CreateSuspiciousIpDto(@ValidIPv4
                                    @NotBlank(message = "Field 'ip' cannot be empty")
                                    String ip) {

}
