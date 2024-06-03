package com.jrinehuls.foodservice.model.dto.nutrition;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientForFactResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class NutritionFactResponseDto {

    private long id;

    private int calories;

    private int servingSize;

    private String servingUnit;

    private List<NutrientForFactResponseDto> nutrients;

}
