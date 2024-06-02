package com.jrinehuls.foodservice.service;

import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactRequestDto;

public interface NutritionFactService {
    NutritionFactResponseDto createNutritionFact(NutritionFactRequestDto requestDto);
}
