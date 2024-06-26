package com.jrinehuls.foodservice.model.dto.nutrient;

import com.jrinehuls.foodservice.validation.Int;
import lombok.Data;

@Data
public class NutrientRequestDto {

    @Int(min = 0, max = 9999, message = "uomId must be between 1 and 9999")
    private Integer amount;

}
