package com.jrinehuls.foodservice.service;

import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomResponseDto;

import java.util.List;

public interface NutrientUomService {

    NutrientUomResponseDto createNutrientUom(NutrientUomRequestDto requestDto);
    NutrientUomResponseDto getNutrientUom(int id);
    NutrientUomResponseDto getNutrientUom(String name);
    List<NutrientUomResponseDto> getAllNutrientUom();
    NutrientUomResponseDto updateNutrientUom(int id, NutrientUomRequestDto requestDto);
    void deleteNutrientUom(int id);

}
