package com.jrinehuls.foodservice.model.dto.nutrient.type;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class NutrientTypeRequestDto {

    @NotBlank(message = "Name cannot be blank or empty")
    @NotNull(message = "Name cannot be null")
    @Length(max = 50, message = "Name cannot be longer that 50 characters")
    private String name;

}
