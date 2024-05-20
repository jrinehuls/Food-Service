package com.jrinehuls.foodservice.exception.notfound;

public class FoodNotFoundException extends NotFoundException{

    public FoodNotFoundException(long id) {
        super(String.format("Food with id %d not found", id));
    }
}
