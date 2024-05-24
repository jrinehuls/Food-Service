package com.jrinehuls.foodservice.controller;

import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;
import com.jrinehuls.foodservice.service.NutrientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nutrient")
@AllArgsConstructor
public class NutrientController {

    private final NutrientService nutrientService;

    @PostMapping()
    public ResponseEntity<NutrientResponseDto> createNutrient(@Valid @RequestBody NutrientRequestDto dto) {
        NutrientResponseDto responseDto = nutrientService.createNutrient(dto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<NutrientResponseDto> getNutrient(@PathVariable long id) {
        NutrientResponseDto responseDto = nutrientService.getNutrient(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<NutrientResponseDto>> getAllNutrients() {
        List<NutrientResponseDto> responseDtos = nutrientService.getAllNutrients();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<NutrientResponseDto> updateNutrient(@PathVariable long id, @Valid @RequestBody NutrientRequestDto dto) {
        NutrientResponseDto responseDto = nutrientService.updateNutrient(id, dto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteNutrient(@PathVariable long id) {
        nutrientService.deleteNutrient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
