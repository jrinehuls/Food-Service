package com.jrinehuls.foodservice.model.dto.nutrition;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class NutritionFactResponseDto {

    private Long id;

    private Integer servingSize;

    private String servingUnit;

    private List<NutrientResponseDto> nutrients;

}
