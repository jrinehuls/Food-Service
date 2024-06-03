package com.jrinehuls.foodservice.exception.notfound;

public class NutritionFactNotFoundException extends NotFoundException {

    public NutritionFactNotFoundException(long id) {
        super("NutritionFact with id: " + id + " not found");
    }
}
