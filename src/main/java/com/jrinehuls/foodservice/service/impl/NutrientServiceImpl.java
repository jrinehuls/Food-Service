package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.conflict.NutrientConflictException;
import com.jrinehuls.foodservice.exception.notfound.NotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientNotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientTypeNotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutritionFactNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;
import com.jrinehuls.foodservice.model.entity.Nutrient;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import com.jrinehuls.foodservice.model.entity.NutritionFact;
import com.jrinehuls.foodservice.service.Findable;
import com.jrinehuls.foodservice.repository.NutrientRepository;
import com.jrinehuls.foodservice.service.NutrientService;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class NutrientServiceImpl implements NutrientService, Findable<Nutrient, Long> {

    private final NutrientRepository nutrientRepository;
    private final Findable<NutrientType, Integer> typeFindable;
    private final Findable<NutritionFact, Long> factFindable;
    private final NutrientMapper mapper;

    @Override
    public NutrientResponseDto createNutrient(int typeId, long factId, NutrientRequestDto requestDto) {
        NutrientType type = typeFindable.findByIdOrThrow(typeId, () -> new NutrientTypeNotFoundException(typeId));
        NutritionFact fact = factFindable.findByIdOrThrow(factId, () -> new NutritionFactNotFoundException(factId));
        this.throwIfExists(typeId, factId);

        Nutrient nutrient = new Nutrient(requestDto.getAmount(), type, fact);
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
        nutrient.setAmount(requestDto.getAmount());
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
        return nutrientRepository.findById(id).orElseThrow(supplier);
    }

    protected void throwIfExists(int nutrientTypeId, long nutritionFactId) {
        Optional<Nutrient> nutrient = nutrientRepository.findByNutrientTypeIdAndNutritionFactId(nutrientTypeId, nutritionFactId);
        if (nutrient.isPresent()) {
            throw new NutrientConflictException(nutrientTypeId, nutritionFactId);
        }
    }


}
