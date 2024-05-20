package com.jrinehuls.foodservice.model.dto.food;

import lombok.Data;

import java.util.UUID;

@Data
public class FoodResponseDto {

    private UUID id;
    private String name;

}
