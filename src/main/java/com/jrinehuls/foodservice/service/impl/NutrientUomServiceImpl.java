package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.conflict.ConflictException;
import com.jrinehuls.foodservice.exception.conflict.NutrientUomConflictException;
import com.jrinehuls.foodservice.exception.notfound.NotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientUomNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.uom.NutrientUomResponseDto;
import com.jrinehuls.foodservice.model.entity.NutrientUom;
import com.jrinehuls.foodservice.repository.NutrientUomRepository;
import com.jrinehuls.foodservice.service.Findable;
import com.jrinehuls.foodservice.service.NutrientUomService;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientUomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class NutrientUomServiceImpl implements NutrientUomService, Findable<NutrientUom, Integer> {

    private final NutrientUomRepository nutrientUomRepository;
    private final NutrientUomMapper mapper;

    @Override
    public NutrientUomResponseDto createNutrientUom(NutrientUomRequestDto requestDto) {
        String name = requestDto.getName();
        this.throwIfExists(name, () -> new NutrientUomConflictException("NutritionUom with name " + name + " already exists"));

        NutrientUom nutrientUom = mapper.mapDtoToNutrientUom(requestDto);
        NutrientUom savedNutrientUom = nutrientUomRepository.save(nutrientUom);
        return mapper.mapNutrientUomToDto(savedNutrientUom);
    }

    @Override
    public NutrientUomResponseDto getNutrientUom(int id) {
        NutrientUom nutrientUom = this.findByIdOrThrow(id, () -> new NutrientUomNotFoundException(id));
        return mapper.mapNutrientUomToDto(nutrientUom);
    }

    @Override
    public NutrientUomResponseDto getNutrientUom(String name) {
        NutrientUom nutrientUom = nutrientUomRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new NutrientUomNotFoundException("NutrientUom with name " + name + " not found"));
        return mapper.mapNutrientUomToDto(nutrientUom);
    }

    @Override
    public List<NutrientUomResponseDto> getAllNutrientUom() {
        List<NutrientUomResponseDto> responseDtos = new ArrayList<>();
        List<NutrientUom> nutrientUoms = nutrientUomRepository.findAll();
        for (NutrientUom nutrientUom : nutrientUoms) {
            responseDtos.add(mapper.mapNutrientUomToDto(nutrientUom));
        }
        return responseDtos;
    }

    @Override
    public NutrientUomResponseDto updateNutrientUom(int id, NutrientUomRequestDto requestDto) {
        NutrientUom nutrientUom = this.findByIdOrThrow(id, () -> new NutrientUomNotFoundException(id));

        String name = requestDto.getName();
        this.throwIfExists(name, () -> new NutrientUomConflictException("NutritionUom with name " + name + " already exists"));

        mapper.mapDtoToNutrientUom(nutrientUom, requestDto);
        NutrientUom updatedNutrientUom = nutrientUomRepository.save(nutrientUom);
        return mapper.mapNutrientUomToDto(updatedNutrientUom);
    }

    @Override
    public void deleteNutrientUom(int id) {
        NutrientUom nutrientUom = this.findByIdOrThrow(id, () -> new NutrientUomNotFoundException(id));
        nutrientUomRepository.delete(nutrientUom);
    }

    @Override
    public <X extends NotFoundException> NutrientUom findByIdOrThrow(Integer id, Supplier<X> supplier) {
        return nutrientUomRepository.findById(id).orElseThrow(supplier);
    }

    @Override
    public <X extends ConflictException> void throwIfExists(String name, Supplier<X> supplier) {
        boolean exists = nutrientUomRepository.findByNameIgnoreCase(name).isPresent();
        if (exists) {
            throw supplier.get();
        }
    }

}
