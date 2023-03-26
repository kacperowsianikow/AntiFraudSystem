package com.antifraud.unlock;

import jakarta.validation.constraints.NotBlank;

public record UnlockAppUser(String email,
                            @NotBlank(message = "Field 'isAccountNonLocked' cannot be empty")
                            Boolean isAccountNonLocked) {

}
