package com.jrinehuls.foodservice.model.dto.nutrition;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;

import java.util.Set;

public class NutritionFactRequestDto {

    private Integer servingSize;

    private String servingUnit;

    private Set<NutrientRequestDto> nutrients;


}
