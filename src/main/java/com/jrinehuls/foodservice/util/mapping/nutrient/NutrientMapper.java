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
        responseDto.setUom(nutrient.getUom().getName());
        responseDto.setType(nutrient.getType().getName());
        return responseDto;
    }

    /*
    public Nutrient mapDtoToNutrient(NutrientRequestDto requestDto) {
        Nutrient nutrient = new Nutrient();
        nutrient.setAmount(requestDto.getAmount());
        nutrient.setName(requestDto.getName());
        return nutrient;
    }

    public void mapDtoToNutrient(Nutrient current, NutrientRequestDto requestDto) {
        current.setName(requestDto.getName());
    }*/

}
