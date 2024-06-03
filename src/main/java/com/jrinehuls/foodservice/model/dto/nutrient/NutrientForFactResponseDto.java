package com.jrinehuls.foodservice.model.dto.nutrient;

import lombok.Data;

@Data
public class NutrientForFactResponseDto {

    private long id;
    private int amount;
    private String unit;
    private String name;
}
