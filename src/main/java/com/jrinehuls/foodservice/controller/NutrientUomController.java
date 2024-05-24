package com.jrinehuls.foodservice.controller;

import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomResponseDto;
import com.jrinehuls.foodservice.service.NutrientUomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nutrient/uom")
@AllArgsConstructor
public class NutrientUomController {

    private final NutrientUomService nutrientUomService;

    @PostMapping()
    public ResponseEntity<NutrientUomResponseDto> createNutrientUom(@Valid @RequestBody NutrientUomRequestDto requestDto) {
        NutrientUomResponseDto responseDto = nutrientUomService.createNutrientUom(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<NutrientUomResponseDto> getNutrientUom(@PathVariable int id) {
        NutrientUomResponseDto responseDto = nutrientUomService.getNutrientUom(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<NutrientUomResponseDto> getNutrientUom(@RequestParam String name) {
        NutrientUomResponseDto responseDto = nutrientUomService.getNutrientUom(name);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NutrientUomResponseDto>> getAllNutrientUom() {
        List<NutrientUomResponseDto> responseDtos = nutrientUomService.getAllNutrientUom();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<NutrientUomResponseDto> updateNutrientUom(@PathVariable int id, @Valid @RequestBody NutrientUomRequestDto requestDto) {
        NutrientUomResponseDto responseDto = nutrientUomService.updateNutrientUom(id, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteNutrientUom(@PathVariable int id) {
        nutrientUomService.deleteNutrientUom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
