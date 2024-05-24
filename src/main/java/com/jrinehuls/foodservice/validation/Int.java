package com.jrinehuls.foodservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntegerValidation.class)
public @interface Int {

    String message() default "Value must be an integer between -2147483648 and 2147483647";
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
