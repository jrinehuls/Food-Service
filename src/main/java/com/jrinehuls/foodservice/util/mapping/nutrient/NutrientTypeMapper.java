package com.jrinehuls.foodservice.util.mapping.nutrient;

import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import org.springframework.stereotype.Component;

@Component
public class NutrientTypeMapper {

    public NutrientTypeResponseDto mapNutrientTypeToDto(NutrientType nutrientType) {
        NutrientTypeResponseDto responseDto = new NutrientTypeResponseDto();
        responseDto.setId(nutrientType.getId());
        nutrientType.setName(nutrientType.getName());
        return responseDto;
    }

    public NutrientType mapDtoToNutrientType(NutrientTypeRequestDto requestDto) {
        NutrientType nutrientType = new NutrientType();
        nutrientType.setName(requestDto.getName());
        return nutrientType;
    }

}
