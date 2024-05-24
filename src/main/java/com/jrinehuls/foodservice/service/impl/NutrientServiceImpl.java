package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.conflict.ConflictException;
import com.jrinehuls.foodservice.exception.notfound.NotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientNotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientTypeNotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientUomNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;
import com.jrinehuls.foodservice.model.entity.Nutrient;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import com.jrinehuls.foodservice.model.entity.NutrientUom;
import com.jrinehuls.foodservice.repository.NutrientRepository;
import com.jrinehuls.foodservice.service.Findable;
import com.jrinehuls.foodservice.service.NutrientService;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class NutrientServiceImpl implements NutrientService, Findable<Nutrient, Long> {

    private final NutrientRepository nutrientRepository;
    private final Findable<NutrientType, Integer> nutrientTypeServiceImpl;
    private final Findable<NutrientUom, Integer> nutrientUomServiceImpl;
    private final NutrientMapper mapper;

    @Override
    public NutrientResponseDto createNutrient(NutrientRequestDto requestDto) {
        int uomId = requestDto.getUomId();
        int typeId = requestDto.getTypeId();

        NutrientUom uom = nutrientUomServiceImpl.findByIdOrThrow(uomId, () -> new NutrientNotFoundException(uomId));
        NutrientType type = nutrientTypeServiceImpl.findByIdOrThrow(typeId, () -> new NutrientTypeNotFoundException(typeId));

        Nutrient nutrient = new Nutrient(requestDto.getAmount(), uom, type);

        Nutrient savedNutrient = nutrientRepository.save(nutrient);

        return mapper.mapNutrientToDto(savedNutrient);
    }

    @Override
    public NutrientResponseDto getNutrient(long id) {
        Nutrient nutrient = this.findByIdOrThrow(id, () -> new NutrientNotFoundException(id));
        return mapper.mapNutrientToDto(nutrient);
    }

    @Override
    public List<NutrientResponseDto> getAllNutrients() {
        List<Nutrient> nutrients = nutrientRepository.findAll();
        List<NutrientResponseDto> responseDtos = new ArrayList<>();

        for (Nutrient nutrient : nutrients) {
            responseDtos.add(mapper.mapNutrientToDto(nutrient));
        }

        return responseDtos;
    }

    @Override
    public NutrientResponseDto updateNutrient(long id, NutrientRequestDto requestDto) {
        Nutrient nutrient = this.findByIdOrThrow(id, () -> new NutrientNotFoundException(id));
        if (nutrient.getType().getId().intValue() != requestDto.getTypeId().intValue()) {
            updateNutrientType(nutrient, requestDto.getTypeId());
        }
        if (nutrient.getUom().getId().intValue() != requestDto.getUomId().intValue()) {
            updateNutrientUom(nutrient, requestDto.getUomId());
        }
        Nutrient updatedNutrient = nutrientRepository.save(nutrient);
        return mapper.mapNutrientToDto(updatedNutrient);
    }

    @Override
    public void deleteNutrient(long id) {
        Nutrient nutrient = findByIdOrThrow(id, () -> new NutrientNotFoundException(id));
        nutrientRepository.delete(nutrient);
    }

    @Override
    public <X extends NotFoundException> Nutrient findByIdOrThrow(Long id, Supplier<X> supplier) {
        return null;
    }

    @Override
    public <X extends ConflictException> void throwIfExists(String field, Supplier<X> supplier) {}

    private void updateNutrientType(Nutrient nutrient, int typeId) {
        NutrientType newType = nutrientTypeServiceImpl.findByIdOrThrow(typeId, () -> new NutrientTypeNotFoundException(typeId));
        nutrient.setType(newType);
    }

    private void updateNutrientUom(Nutrient nutrient, int uomId) {
        NutrientUom newUom = nutrientUomServiceImpl.findByIdOrThrow(uomId, () -> new NutrientUomNotFoundException(uomId));
        nutrient.setUom(newUom);
    }

}
