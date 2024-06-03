package com.jrinehuls.foodservice.controller;

import com.jrinehuls.foodservice.model.dto.food.FoodRequestDto;
import com.jrinehuls.foodservice.model.dto.food.FoodResponseDto;
import com.jrinehuls.foodservice.model.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/food")
@AllArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FoodResponseDto> createFood(@RequestBody FoodRequestDto requestDto) {
        FoodResponseDto responseDto = foodService.createFood(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
