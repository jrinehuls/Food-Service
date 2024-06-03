package com.jrinehuls.foodservice.util.mapping.nutrient;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;
import com.jrinehuls.foodservice.model.entity.Nutrient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NutrientMapper {

    private final NutrientTypeMapper typeMapper;

    public NutrientResponseDto mapNutrientToDto(Nutrient nutrient) {
        NutrientResponseDto responseDto = new NutrientResponseDto();
        responseDto.setId(nutrient.getId());
        responseDto.setAmount(nutrient.getAmount());
        responseDto.setNutrientType(typeMapper.mapNutrientTypeToDto(nutrient.getNutrientType()));
        responseDto.setNutritionFactId(nutrient.getNutritionFact().getId());
        return responseDto;
    }

}
