package com.jrinehuls.foodservice.validation;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IntegerValidation implements ConstraintValidator<Int, Integer> {

    int min;
    int max;

    @Override
    public void initialize(Int constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        return value >= min && value <= max;
    }

}
