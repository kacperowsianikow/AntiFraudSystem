package com.antifraud.ips;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class IPv4ConstraintValidator implements ConstraintValidator<ValidIPv4, String> {
    private static final Pattern IPV4_PATTERN =
            Pattern.compile(
                    "^((([01]?\\d\\d?)|(2[0-4]\\d)|(25[0-5]))\\.){3}(([01]?\\d\\d?)|(2[0-4]\\d)|(25[0-5]))$"
            );

    @Override
    public void initialize(ValidIPv4 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String ipAddress, ConstraintValidatorContext constraintValidatorContext) {
        return IPV4_PATTERN.matcher(ipAddress).matches();
    }

}
