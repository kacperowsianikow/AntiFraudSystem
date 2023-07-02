package com.antifraud.user.dtos;

import com.antifraud.user.password.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public record ChangePasswordDto(@ValidPassword
                                @NotBlank(message = "Field 'newPassword' cannot be empty")
                                String newPassword,
                                @NotBlank(message = "Field 'oldPassword' cannot be empty")
                                String oldPassword) {

}
