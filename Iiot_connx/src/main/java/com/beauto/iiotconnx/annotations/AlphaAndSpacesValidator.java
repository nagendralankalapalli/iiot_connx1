package com.beauto.iiotconnx.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphaAndSpacesValidator implements ConstraintValidator<AlphaAndSpaces, String> {
    @Override
    public void initialize(AlphaAndSpaces constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null values are considered valid, change as needed
        }
        // Use a regular expression to check if the value contains only alphabets and spaces
        return value.matches("^[a-zA-Z ]*$");
    }
}