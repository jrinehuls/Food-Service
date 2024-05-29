package com.jrinehuls.foodservice.model.dto.nutrition;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;
import com.jrinehuls.foodservice.validation.Int;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class NutritionFactRequestDto {

    @Int(min = 0, max = 9999, message = "servingSize must be between 1 and 9999")
    private Integer servingSize;

    @NotNull(message = "servingUnit is required")
    @NotBlank(message = "servingUnit cannot be blank or empty")
    private String servingUnit;

    private List<NutrientRequestDto> nutrients;

}
