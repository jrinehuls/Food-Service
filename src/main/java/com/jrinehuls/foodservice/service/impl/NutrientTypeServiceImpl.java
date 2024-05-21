package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import com.jrinehuls.foodservice.model.entity.NutrientUom;
import com.jrinehuls.foodservice.repository.NutrientTypeRepository;
import com.jrinehuls.foodservice.service.NutrientTypeService;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NutrientTypeServiceImpl implements NutrientTypeService {

    private final NutrientTypeRepository nutrientTypeRepository;
    private final NutrientTypeMapper mapper;

    @Override
    public NutrientTypeResponseDto createNutrientType(NutrientTypeRequestDto requestDto) {
        NutrientType nutrientType = mapper.mapDtoToNutrientType(requestDto);
        NutrientType savedNutrientType = nutrientTypeRepository.save(nutrientType);
        return mapper.mapNutrientTypeToDto(savedNutrientType);
    }

    @Override
    public NutrientTypeResponseDto getNutrientType(int id) {
        return null;
    }

    @Override
    public List<NutrientTypeResponseDto> getAllNutrientTypes() {
        return null;
    }

    @Override
    public NutrientTypeResponseDto updateNutrientType(int id, NutrientTypeRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteNutrientType(int id) {

    }
}
