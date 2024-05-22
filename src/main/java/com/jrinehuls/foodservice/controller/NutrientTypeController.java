package com.jrinehuls.foodservice.controller;

import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import com.jrinehuls.foodservice.service.NutrientTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<NutrientTypeResponseDto> getNutrientType(@PathVariable int id) {
        NutrientTypeResponseDto responseDto = nutrientTypeService.getNutrientType(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<NutrientTypeResponseDto> getNutrientType(@RequestParam String name) {
        NutrientTypeResponseDto responseDto = nutrientTypeService.getNutrientType(name);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NutrientTypeResponseDto>> GetAllNutrientTypes() {
        List<NutrientTypeResponseDto> responseDtos = nutrientTypeService.getAllNutrientTypes();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<NutrientTypeResponseDto> updateNutrientType(@PathVariable int id, @Valid @RequestBody NutrientTypeRequestDto requestDto) {
        NutrientTypeResponseDto responseDto = nutrientTypeService.updateNutrientType(id, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteNutrientType(@PathVariable int id) {
        nutrientTypeService.deleteNutrientType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
