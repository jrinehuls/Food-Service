package com.jrinehuls.foodservice.util.mapping.nutrition;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientForFactResponseDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;
import com.jrinehuls.foodservice.model.entity.Nutrient;
import com.jrinehuls.foodservice.model.entity.NutritionFact;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@AllArgsConstructor
public class NutritionFactMapper {

    private final NutrientMapper nutrientMapper;

    public NutritionFact mapDtoToNutritionFact(NutritionFactRequestDto requestDto) {
        NutritionFact fact = new NutritionFact();
        fact.setServingSize(requestDto.getServingSize());
        fact.setServingUnit(requestDto.getServingUnit());
        return fact;
    }

    public void mapDtoToNutritionFact(NutritionFact nutritionFact, NutritionFactRequestDto requestDto) {
        nutritionFact.setServingSize(requestDto.getServingSize());
        nutritionFact.setServingUnit(requestDto.getServingUnit());
    }

    public NutritionFactResponseDto mapFactToDto(NutritionFact nutritionFact) {
        NutritionFactResponseDto responseDto = new NutritionFactResponseDto();
        List<NutrientForFactResponseDto> nutrients = new ArrayList<>();
        for (Nutrient nutrient : nutritionFact.getNutrients()) {
            nutrients.add(nutrientMapper.mapNutrientToDtoForFact(nutrient));
        }
        responseDto.setId(nutritionFact.getId());
        responseDto.setServingSize(nutritionFact.getServingSize());
        responseDto.setServingUnit(nutritionFact.getServingUnit());
        responseDto.setCalories(this.calcCalories(nutrients));
        responseDto.setNutrients(nutrients);
        return responseDto;
    }

    protected int calcCalories(List<NutrientForFactResponseDto> nutrients) {
        int calories = 0;
        for (NutrientForFactResponseDto nutrient : nutrients) {
            switch (nutrient.getName().toLowerCase()) {
                case "fat" -> calories += 9;
                case "carbohydrate", "protein" -> calories += 4;
                default -> {}
            }
        }
        return calories;
    }
}
