package com.jrinehuls.foodservice.model.service;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;

import java.util.List;

public interface NutrientService {

    NutrientResponseDto createNutrient(int typeId, long factId,NutrientRequestDto requestDto);
    NutrientResponseDto getNutrient(long id);
    List<NutrientResponseDto> getAllNutrients();
    NutrientResponseDto updateNutrient(long id, NutrientRequestDto requestDto);
    void deleteNutrient(long id);

}
