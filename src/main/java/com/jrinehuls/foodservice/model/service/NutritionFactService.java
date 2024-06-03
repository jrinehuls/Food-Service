package com.jrinehuls.foodservice.model.service;

import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactRequestDto;

import java.util.List;

public interface NutritionFactService {
    NutritionFactResponseDto createNutritionFact(NutritionFactRequestDto requestDto);

    NutritionFactResponseDto getNutritionFact(long id);

    List<NutritionFactResponseDto> getAllNutritionFacts();

    NutritionFactResponseDto updateNutritionFact(long id, NutritionFactRequestDto requestDto);

    void deleteNutritionFact(long id);

}
