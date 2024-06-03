package com.jrinehuls.foodservice.model.dto.nutrient;

import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import lombok.Data;

@Data
public class NutrientResponseDto {

    private Long id;
    private Integer amount;
    private NutrientTypeResponseDto nutrientType;
    private Long nutritionFactId;

}
