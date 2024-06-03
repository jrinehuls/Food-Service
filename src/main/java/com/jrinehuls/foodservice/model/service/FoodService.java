package com.jrinehuls.foodservice.model.service;

import com.jrinehuls.foodservice.model.dto.food.FoodRequestDto;
import com.jrinehuls.foodservice.model.dto.food.FoodResponseDto;

import java.util.List;
import java.util.UUID;

public interface FoodService {

    FoodResponseDto createFood(FoodRequestDto requestDto);
    List<FoodResponseDto> getAllFoods();
    FoodResponseDto getFood(UUID id);
    FoodResponseDto updateFood(FoodRequestDto requestDto, UUID id);
    void deleteFood(UUID id);

}
