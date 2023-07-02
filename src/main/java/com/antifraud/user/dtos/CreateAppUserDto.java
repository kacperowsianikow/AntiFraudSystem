package com.antifraud.user.dtos;

import com.antifraud.user.password.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateAppUserDto(@NotBlank(message = "Field 'firstname' cannot be empty")
                               String firstname,
                               @NotBlank(message = "Field 'lastname' cannot be empty")
                               String lastname,
                               @NotBlank(message = "Field 'email' cannot be empty")
                               @Email
                               String email,
                               @ValidPassword
                               @NotBlank(message = "Field 'password' cannot be empty")
                               String password) {

}
