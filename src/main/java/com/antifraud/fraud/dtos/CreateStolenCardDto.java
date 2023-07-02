package com.antifraud.fraud.dtos;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.LuhnCheck;

public record CreateStolenCardDto(@LuhnCheck
                                  @NotBlank(message = "Field 'number' cannot be empty")
                                  String cardNumber) {

}
