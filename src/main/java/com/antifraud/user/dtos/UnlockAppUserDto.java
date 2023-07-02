package com.antifraud.user.dtos;

import jakarta.validation.constraints.NotBlank;

public record UnlockAppUserDto(String email,
                               @NotBlank(message = "Field 'isAccountNonLocked' cannot be empty")
                               Boolean isAccountNonLocked) {

}
