package com.jrinehuls.foodservice.util.mapping.nutrient;

import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import org.springframework.stereotype.Component;

@Component
public class NutrientTypeMapper {

    public NutrientTypeResponseDto mapNutrientTypeToDto(NutrientType nutrientType) {
        NutrientTypeResponseDto responseDto = new NutrientTypeResponseDto();
        responseDto.setId(nutrientType.getId());
        responseDto.setName(nutrientType.getName());
        responseDto.setUom(nutrientType.getUom());
        return responseDto;
    }

}
