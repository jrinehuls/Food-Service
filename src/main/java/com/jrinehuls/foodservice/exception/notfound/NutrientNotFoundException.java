package com.jrinehuls.foodservice.exception.notfound;

public class NutrientNotFoundException extends NotFoundException {

    public NutrientNotFoundException(long id) {
        super(String.format("Nutrient with id %d not found", id));
    }

    public NutrientNotFoundException(String message) {
        super(message);
    }
}
