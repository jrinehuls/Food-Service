package com.jrinehuls.foodservice.exception.notfound;

public class NutrientUomNotFoundException extends NotFoundException {

    public NutrientUomNotFoundException(int id) {
        super("NutrientUom with id " + id + " not found");
    }

    public NutrientUomNotFoundException(String message) {
        super(message);
    }

}
