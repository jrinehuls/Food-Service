package com.jrinehuls.foodservice.model.dto.nutrient;

import com.jrinehuls.foodservice.validation.Int;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NutrientRequestDto {

    @Int(min = 0, max = 9999, message = "uomId must be between 1 and 9999")
    private Integer amount;

    @NotNull(message = "type cannot be null")
    @NotBlank(message = "type cannot be empty or blank")
    private String uom;

    @NotNull(message = "type cannot be null")
    @NotBlank(message = "type cannot be empty or blank")
    private String type;

}
