package com.antifraud.changepassword;

import com.antifraud.registration.password.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequest(@ValidPassword
                                    @NotBlank(message = "Field 'newPassword' cannot be empty")
                                    String newPassword,
                                    @NotBlank(message = "Field 'oldPassword' cannot be empty")
                                    String oldPassword) {

}
