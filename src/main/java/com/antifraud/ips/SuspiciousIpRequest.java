package com.antifraud.ips;

import jakarta.validation.constraints.NotBlank;

public record SuspiciousIpRequest(@ValidIPv4
                                  @NotBlank(message = "Field 'ip' cannot be empty")
                                  String ip) {

}
