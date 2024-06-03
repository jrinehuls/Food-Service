package com.jrinehuls.foodservice.service;

import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;

import java.util.List;

public interface NutrientTypeService {

    NutrientTypeResponseDto getNutrientType(int id);
    NutrientTypeResponseDto getNutrientType(String name);
    List<NutrientTypeResponseDto> getAllNutrientTypes();

}
