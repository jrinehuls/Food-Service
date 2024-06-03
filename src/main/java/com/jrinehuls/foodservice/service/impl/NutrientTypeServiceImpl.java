package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.notfound.NotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientTypeNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import com.jrinehuls.foodservice.repository.NutrientTypeRepository;
import com.jrinehuls.foodservice.service.Findable;
import com.jrinehuls.foodservice.service.NutrientTypeService;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class NutrientTypeServiceImpl implements NutrientTypeService, Findable<NutrientType, Integer> {

    private final NutrientTypeRepository nutrientTypeRepository;
    private final NutrientTypeMapper mapper;

    @Override
    public NutrientTypeResponseDto getNutrientType(int id) {
        NutrientType nutrientType = this.findByIdOrThrow(id, () -> new NutrientTypeNotFoundException(id));
        return mapper.mapNutrientTypeToDto(nutrientType);
    }

    @Override
    public NutrientTypeResponseDto getNutrientType(String name) {
        NutrientType nutrientType = nutrientTypeRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new NutrientTypeNotFoundException("NutrientType with name " + name + " not found"));
        return mapper.mapNutrientTypeToDto(nutrientType);
    }

    @Override
    public List<NutrientTypeResponseDto> getAllNutrientTypes() {
        List<NutrientTypeResponseDto> responseDtos = new ArrayList<>();
        List<NutrientType> nutrientTypes = nutrientTypeRepository.findAll();
        for (NutrientType nutrientType : nutrientTypes) {
            responseDtos.add(mapper.mapNutrientTypeToDto(nutrientType));
        }
        return responseDtos;
    }

    @Override
    public <X extends NotFoundException> NutrientType findByIdOrThrow(Integer id, Supplier<X> supplier) {
        return nutrientTypeRepository.findById(id).orElseThrow(supplier);
    }

}
