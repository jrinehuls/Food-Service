package com.jrinehuls.foodservice.model.dto.nutrient.uom;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class NutrientUomRequestDto {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty or blank")
    @Length(max = 50, message = "Name cannot be longer than 50 characters")
    private String name;

}
