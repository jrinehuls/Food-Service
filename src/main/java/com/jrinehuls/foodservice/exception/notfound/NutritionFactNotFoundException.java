package com.jrinehuls.foodservice.exception.notfound;

import com.jrinehuls.foodservice.model.entity.NutritionFact;

public class NutritionFactNotFoundException extends NotFoundException {

    public NutritionFactNotFoundException(long id) {
        super("NutritionFact with id: " + id + " not found");
    }
}
