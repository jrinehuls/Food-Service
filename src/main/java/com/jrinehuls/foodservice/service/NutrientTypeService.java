package com.jrinehuls.foodservice.service;

import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;

import java.util.List;

public interface NutrientTypeService {
    NutrientTypeResponseDto createNutrientType(NutrientTypeRequestDto requestDto);
    NutrientTypeResponseDto getNutrientType(int id);

    NutrientTypeResponseDto getNutrientType(String name);
    List<NutrientTypeResponseDto> getAllNutrientTypes();
    NutrientTypeResponseDto updateNutrientType(int id, NutrientTypeRequestDto requestDto);
    void deleteNutrientType(int id);
}
