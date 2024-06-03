package com.jrinehuls.foodservice.util.mapping.nutrient;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;
import com.jrinehuls.foodservice.model.entity.Nutrient;
import org.springframework.stereotype.Component;

@Component
public class NutrientMapper {

    public NutrientResponseDto mapNutrientToDto(Nutrient nutrient) {
        NutrientResponseDto responseDto = new NutrientResponseDto();
        responseDto.setId(nutrient.getId());
        responseDto.setAmount(nutrient.getAmount());
        responseDto.setNutrientTypeId(nutrient.getType().getId());
        responseDto.setNutritionFactId(nutrient.getNutritionFact().getId());
        return responseDto;
    }

}
