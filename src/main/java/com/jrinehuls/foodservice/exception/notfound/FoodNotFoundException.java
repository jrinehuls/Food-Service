package com.jrinehuls.foodservice.exception.notfound;

import java.util.UUID;

public class FoodNotFoundException extends NotFoundException {

    public FoodNotFoundException(UUID id) {
        super(String.format("Food with id %s not found", id.toString()));
    }

}
