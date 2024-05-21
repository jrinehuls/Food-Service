package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.conflict.NutritionTypeConflictException;
import com.jrinehuls.foodservice.exception.notfound.NutrientTypeNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import com.jrinehuls.foodservice.repository.NutrientTypeRepository;
import com.jrinehuls.foodservice.service.NutrientTypeService;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class NutrientTypeServiceImpl implements NutrientTypeService {

    private final NutrientTypeRepository nutrientTypeRepository;
    private final NutrientTypeMapper mapper;

    @Override
    public NutrientTypeResponseDto createNutrientType(NutrientTypeRequestDto requestDto) {
        Optional<NutrientType> existingNutrientType = nutrientTypeRepository.findByNameIgnoreCase(requestDto.getName());
        if (existingNutrientType.isPresent()) {
            String message = String.format("NutritionType with name %s already exists", requestDto.getName());
            throw new NutritionTypeConflictException(message);
        }
        NutrientType nutrientType = mapper.mapDtoToNutrientType(requestDto);
        NutrientType savedNutrientType = nutrientTypeRepository.save(nutrientType);
        return mapper.mapNutrientTypeToDto(savedNutrientType);
    }

    @Override
    public NutrientTypeResponseDto getNutrientType(int id) {
        NutrientType nutrientType = nutrientTypeRepository.findById(id)
                .orElseThrow(() -> new NutrientTypeNotFoundException(id));
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
    public NutrientTypeResponseDto updateNutrientType(int id, NutrientTypeRequestDto requestDto) {
        NutrientType nutrientType = nutrientTypeRepository.findById(id)
                .orElseThrow(() -> new NutrientTypeNotFoundException(id));

        Optional<NutrientType> existingNutrientType = nutrientTypeRepository.findByNameIgnoreCase(requestDto.getName());
        if (existingNutrientType.isPresent()) {
            String message = String.format("NutritionType with name %s already exists", requestDto.getName());
            throw new NutritionTypeConflictException(message);
        }

        mapper.mapDtoToNutrientType(nutrientType, requestDto);
        NutrientType updatedNutrientType = nutrientTypeRepository.save(nutrientType);
        return mapper.mapNutrientTypeToDto(updatedNutrientType);
    }

    @Override
    public void deleteNutrientType(int id) {
        NutrientType nutrientType = nutrientTypeRepository.findById(id)
                .orElseThrow(() -> new NutrientTypeNotFoundException(id));
        nutrientTypeRepository.delete(nutrientType);
    }
    
}
