package com.beauto.iiotconnx.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; 
        }        
        // Define your password validation criteria
        boolean hasMinimumLength = value.length() >= 8;
        boolean hasUpperCase = !value.equals(value.toLowerCase());
        boolean hasLowerCase = !value.equals(value.toUpperCase());
        boolean hasDigit = value.matches(".*\\d.*");
        boolean hasSpecialCharacter = value.matches(".*[^a-zA-Z0-9].*");
        
        return hasMinimumLength && hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter;
    }
}