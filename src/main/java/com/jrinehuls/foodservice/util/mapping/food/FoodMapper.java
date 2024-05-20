package com.jrinehuls.foodservice.util.mapping.food;

import com.jrinehuls.foodservice.model.dto.food.FoodRequestDto;
import com.jrinehuls.foodservice.model.dto.food.FoodResponseDto;
import com.jrinehuls.foodservice.model.entity.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {

    public Food mapRequestToFood(FoodRequestDto dto) {
        Food food = new Food();
        food.setName(dto.getName());
        return food;
    }

    public FoodResponseDto mapFoodToDto(Food food) {
        FoodResponseDto dto = new FoodResponseDto();
        dto.setId(food.getId());
        dto.setName(food.getName());
        return dto;
    }
}
