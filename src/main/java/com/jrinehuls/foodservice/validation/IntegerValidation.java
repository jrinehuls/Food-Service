package com.jrinehuls.foodservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IntegerValidation implements ConstraintValidator<Int, Object> {

    int min;
    int max;

    @Override
    public void initialize(Int constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        if (value instanceof Integer) {
            int intValue = (Integer) value;
            return intValue >= min && intValue <= max;
        }
        return false;
    }

}
