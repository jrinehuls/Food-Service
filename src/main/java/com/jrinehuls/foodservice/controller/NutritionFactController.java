package com.jrinehuls.foodservice.controller;

import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;
import com.jrinehuls.foodservice.service.NutritionFactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nutrition-fact")
@AllArgsConstructor
public class NutritionFactController {

    private final NutritionFactService factService;

    @PostMapping
    public ResponseEntity<NutritionFactResponseDto> createNutritionFact(@Valid @RequestBody NutritionFactRequestDto requestDto) {
        NutritionFactResponseDto responseDto = factService.createNutritionFact(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<NutritionFactResponseDto> getNutritionFact(@PathVariable long id) {
        NutritionFactResponseDto responseDto = factService.getNutritionFact(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NutritionFactResponseDto>> getNutritionFacts() {
        List<NutritionFactResponseDto> responseDtos = factService.getAllNutritionFacts();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<NutritionFactResponseDto> updateNutritionFact(@PathVariable long id, @Valid @RequestBody NutritionFactRequestDto requestDto) {
        NutritionFactResponseDto responseDto = factService.updateNutritionFact(id, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteNutritionFact(@PathVariable long id) {
        factService.deleteNutritionFact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
