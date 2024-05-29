package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;
import com.jrinehuls.foodservice.repository.NutritionFactRepository;
import com.jrinehuls.foodservice.service.NutritionFactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NutritionFactServiceImpl implements NutritionFactService {

    private final NutritionFactRepository nutritionFactRepository;

    @Override
    public NutritionFactResponseDto createNutrition(NutrientUomRequestDto requestDto) {
        return null;
    }

}
