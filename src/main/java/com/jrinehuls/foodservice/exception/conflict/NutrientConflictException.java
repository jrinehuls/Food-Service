package com.jrinehuls.foodservice.exception.conflict;

public class NutrientConflictException extends ConflictException {

    public NutrientConflictException(int nutrientTypeId, long nutritionFactId) {
        super(String.format("Nutrient with nutrientTypeId %s and nutritionFactId %s already exists", nutrientTypeId, nutritionFactId));
    }

}
