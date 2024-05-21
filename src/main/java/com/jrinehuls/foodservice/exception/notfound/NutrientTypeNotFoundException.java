package com.jrinehuls.foodservice.exception.notfound;

public class NutrientTypeNotFoundException extends NotFoundException {

    public NutrientTypeNotFoundException(int id) {
        super("NutrientType with id " + id + " not found");
    }

    public NutrientTypeNotFoundException(String message) {
        super(message);
    }
}
