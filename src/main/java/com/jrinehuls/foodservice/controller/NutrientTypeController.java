package com.jrinehuls.foodservice.controller;

import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import com.jrinehuls.foodservice.service.NutrientTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nutrient/type")
@AllArgsConstructor
public class NutrientTypeController {

    private final NutrientTypeService nutrientTypeService;

    @PostMapping()
    public ResponseEntity<NutrientTypeResponseDto> createNutrientType(@Valid @RequestBody NutrientTypeRequestDto requestDto) {
        NutrientTypeResponseDto responseDto = nutrientTypeService.createNutrientType(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
