package com.jrinehuls.foodservice.exception.badrequest;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;

public class DuplicateNutrientRequestTypeException extends BadRequestException {

    public DuplicateNutrientRequestTypeException(NutrientRequestDto nutrientRequestDto) {
        super("NutrientType cannot be duplicated in request. Duplicate value " + nutrientRequestDto.getType());
    }
}
