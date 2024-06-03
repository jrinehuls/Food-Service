package com.jrinehuls.foodservice.model.service.impl;

import com.jrinehuls.foodservice.model.dto.food.FoodRequestDto;
import com.jrinehuls.foodservice.model.dto.food.FoodResponseDto;
import com.jrinehuls.foodservice.model.entity.Food;
import com.jrinehuls.foodservice.model.service.FoodService;
import com.jrinehuls.foodservice.repository.FoodRepository;
import com.jrinehuls.foodservice.util.mapping.food.FoodMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    @Override
    public FoodResponseDto createFood(FoodRequestDto requestDto) {
        Food food = foodMapper.mapRequestToFood(requestDto);
        Food savedFood = foodRepository.save(food);
        return foodMapper.mapFoodToDto(savedFood);
    }

    @Override
    public List<FoodResponseDto> getAllFoods() {
        return null;
    }

    @Override
    public FoodResponseDto getFood(UUID id) {
        return null;
    }

    @Override
    public FoodResponseDto updateFood(FoodRequestDto requestDto, UUID id) {
        return null;
    }

    @Override
    public void deleteFood(UUID id) {

    }
}
