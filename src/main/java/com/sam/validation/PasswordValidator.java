package com.sam.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator
        implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword annotation) {
    }

    @Override
    public boolean isValid(String password,
            ConstraintValidatorContext context) {

        if (password == null || password.isBlank()) {
            return true;
        }

        boolean hasUppercase = password.chars()
                .anyMatch(Character::isUpperCase);

        boolean hasDigit = password.chars()
                .anyMatch(Character::isDigit);

        if (!hasUppercase || !hasDigit) {
            context.disableDefaultConstraintViolation();
            StringBuilder msg = new StringBuilder(
                    "Password must contain:");
            if (!hasUppercase)
                msg.append(" at least one uppercase letter;");
            if (!hasDigit)
                msg.append(" at least one number;");
            context.buildConstraintViolationWithTemplate(
                    msg.toString())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}