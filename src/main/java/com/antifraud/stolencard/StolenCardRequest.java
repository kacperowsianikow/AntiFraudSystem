package com.antifraud.stolencard;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.LuhnCheck;

public record StolenCardRequest(@LuhnCheck
                                @NotBlank(message = "Field 'number' cannot be empty")
                                String cardNumber) {

}
