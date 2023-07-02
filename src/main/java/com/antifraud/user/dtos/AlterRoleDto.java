package com.antifraud.user.dtos;

import com.antifraud.user.enums.AppUserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record AlterRoleDto(@Email
                           String email,
                           @NotBlank(message = "Field 'role' cannot be empty")
                           List<AppUserRole> roles) {

}
