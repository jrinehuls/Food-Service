package com.jrinehuls.foodservice.model.dto.nutrient;

import com.jrinehuls.foodservice.validation.Int;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NutrientRequestDto {

    // TODO: Make Double Validation
    @NotNull
    @Min(value = 1, message = "amount must be positive")
    private Double amount;

    @Int(min = 1, message = "uomId must be between 1 and 2147483647")
    private Integer uomId;

    @Int(min = 1, message = "typeId must be between 1 and 2147483647")
    private Integer typeId;

}
