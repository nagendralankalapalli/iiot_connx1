package com.beauto.iiotconnx.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositiveLongValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveLong {
	String message() default "Value must be a positive long number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}