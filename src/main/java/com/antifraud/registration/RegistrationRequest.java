package com.antifraud.registration;

import com.antifraud.registration.password.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public record RegistrationRequest(@NotBlank(message = "Field 'firstname' cannot be empty")
                                  String firstname,
                                  @NotBlank(message = "Field 'lastname' cannot be empty")
                                  String lastname,
                                  @NotBlank(message = "Field 'email' cannot be empty")
                                  String email,
                                  @ValidPassword
                                  @NotBlank(message = "Field 'password' cannot be empty")
                                  String password) {

}
