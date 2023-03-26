package com.antifraud.alterRole;

import com.antifraud.appuser.AppUserRole;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record AlterRoleRequest(String email,
                               @NotBlank(message = "Field 'role' cannot be empty")
                               List<AppUserRole> roles) {

}
