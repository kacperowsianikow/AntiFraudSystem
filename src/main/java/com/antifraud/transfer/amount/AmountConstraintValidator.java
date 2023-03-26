package com.antifraud.transfer.amount;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class AmountConstraintValidator implements ConstraintValidator<ValidAmount, Long> {
    private static final String AMOUNT_PATTERN = "[^0-9]";

    @Override
    public void initialize(ValidAmount constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long amount, ConstraintValidatorContext constraintValidatorContext) {
        String amountValue = Long.toString(amount);

        return !amountValue.matches(AMOUNT_PATTERN);
    }

}
