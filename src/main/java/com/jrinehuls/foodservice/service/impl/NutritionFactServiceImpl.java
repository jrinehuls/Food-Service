package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.badrequest.DuplicateNutrientRequestTypeException;
import com.jrinehuls.foodservice.exception.conflict.ConflictException;
import com.jrinehuls.foodservice.exception.notfound.NotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientTypeNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;
import com.jrinehuls.foodservice.model.entity.Nutrient;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import com.jrinehuls.foodservice.model.entity.NutritionFact;
import com.jrinehuls.foodservice.repository.NutrientTypeRepository;
import com.jrinehuls.foodservice.repository.NutritionFactRepository;
import com.jrinehuls.foodservice.service.Findable;
import com.jrinehuls.foodservice.service.NutritionFactService;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class NutritionFactServiceImpl implements NutritionFactService, Findable<NutritionFact, Long> {

    private final NutritionFactRepository nutritionFactRepository;
    private final NutrientMapper nutrientMapper;
    private final NutrientTypeRepository typeRepository;

    // TODO: Create mapper

    @Override
    public NutritionFactResponseDto createNutritionFact(NutritionFactRequestDto requestDto) {
            // TODO: For each nutrient, check if name repeats. If so, throw exception
            // TODO: For each nutrient, check if type exists. If not, throw exception
            // TODO: Once all checks are successful, save NutritionFact, then all Nutrients
            // TODO: If nutrient list length == 0, save NutritionFact
            return null;
    }

    @Override
    public NutritionFactResponseDto getNutritionFact(long id) {
        return null;
    }

    @Override
    public List<NutritionFactResponseDto> getAllNutritionFacts() {
        return null;
    }

    @Override
    public NutritionFactResponseDto updateNutritionFact(long id, NutritionFactRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteNutritionFact(long id) {

    }

    @Override
    public <X extends NotFoundException> NutritionFact findByIdOrThrow(Long id, Supplier<X> supplier) {
        return nutritionFactRepository.findById(id).orElseThrow(supplier);
    }

    @Override
    public <X extends NotFoundException> NutritionFact findByNameOrThrow(String name, Supplier<X> supplier) {
        return null;
    }

    @Override
    public <X extends ConflictException> void throwIfExists(String field, Supplier<X> supplier) {

    }
}
