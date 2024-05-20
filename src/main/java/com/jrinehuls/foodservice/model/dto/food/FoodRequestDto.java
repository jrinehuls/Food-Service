package com.jrinehuls.foodservice.model.dto.food;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class FoodRequestDto {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank or empty")
    @Length(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

}
