package com.jrinehuls.foodservice.model.dto.nutrient;

import lombok.Data;

@Data
public class NutrientResponseDto {

    private Long id;
    private Integer amount;
    private String uom;
    private String type;

}
