package com.jrinehuls.foodservice.util.mapping.nutrient;

import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomResponseDto;
import com.jrinehuls.foodservice.model.entity.NutrientUom;
import org.springframework.stereotype.Component;

@Component
public class NutrientUomMapper {

    public NutrientUomResponseDto mapNutrientUomToDto(NutrientUom nutrientUom) {
        NutrientUomResponseDto responseDto = new NutrientUomResponseDto();
        responseDto.setId(nutrientUom.getId());
        responseDto.setName(nutrientUom.getName());
        return responseDto;
    }

    public NutrientUom mapDtoToNutrientTUom(NutrientUomRequestDto requestDto) {
        NutrientUom nutrientUom = new NutrientUom();
        nutrientUom.setName(requestDto.getName());
        return nutrientUom;
    }

}
