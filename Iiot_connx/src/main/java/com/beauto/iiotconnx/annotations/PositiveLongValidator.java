package com.beauto.iiotconnx.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PositiveLongValidator implements ConstraintValidator<PositiveLong, Long> {

    @Override
    public void initialize(PositiveLong constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != null && value > 0;
    }
}