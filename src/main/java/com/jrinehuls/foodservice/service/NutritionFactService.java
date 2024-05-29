package com.jrinehuls.foodservice.service;

import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;

public interface NutritionFactService {
    NutritionFactResponseDto createNutrition(NutrientUomRequestDto requestDto);
}
