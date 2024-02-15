package com.beauto.iiotconnx.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AlphaAndSpacesValidator.class)
@Documented
public @interface AlphaAndSpaces {
    String message() default "Invalid format. Only alphabets and spaces are allowed.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}