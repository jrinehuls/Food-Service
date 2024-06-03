package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.notfound.NotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutritionFactNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;
import com.jrinehuls.foodservice.model.entity.NutritionFact;
import com.jrinehuls.foodservice.repository.NutritionFactRepository;
import com.jrinehuls.foodservice.service.Findable;
import com.jrinehuls.foodservice.service.NutritionFactService;
import com.jrinehuls.foodservice.util.mapping.nutrition.NutritionFactMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class NutritionFactServiceImpl implements NutritionFactService, Findable<NutritionFact, Long> {

    private final NutritionFactRepository nutritionFactRepository;
    private final NutritionFactMapper mapper;

    @Override
    public NutritionFactResponseDto createNutritionFact(NutritionFactRequestDto requestDto) {
        NutritionFact nutritionFact = mapper.mapDtoToNutritionFact(requestDto);
        NutritionFact savedFact = nutritionFactRepository.save(nutritionFact);
        return mapper.mapFactToDto(savedFact);
    }

    @Override
    public NutritionFactResponseDto getNutritionFact(long id) {
        NutritionFact fact = this.findByIdOrThrow(id, () -> new NutritionFactNotFoundException(id));
        return mapper.mapFactToDto(fact);
    }

    @Override
    public List<NutritionFactResponseDto> getAllNutritionFacts() {
        List<NutritionFact> nutritionFacts = nutritionFactRepository.findAll();
        List<NutritionFactResponseDto> responseDtos = new ArrayList<>();
        for (NutritionFact fact : nutritionFacts) {
            responseDtos.add(mapper.mapFactToDto(fact));
        }
        return responseDtos;
    }

    @Override
    public NutritionFactResponseDto updateNutritionFact(long id, NutritionFactRequestDto requestDto) {
        NutritionFact nutritionFact = this.findByIdOrThrow(id, () -> new NutritionFactNotFoundException(id));
        mapper.mapDtoToNutritionFact(nutritionFact, requestDto);
        NutritionFact updatedFact = nutritionFactRepository.save(nutritionFact);
        return mapper.mapFactToDto(updatedFact);
    }

    @Override
    public void deleteNutritionFact(long id) {
        NutritionFact nutritionFact = this.findByIdOrThrow(id, () -> new NutritionFactNotFoundException(id));
        nutritionFactRepository.delete(nutritionFact);
    }

    @Override
    public <X extends NotFoundException> NutritionFact findByIdOrThrow(Long id, Supplier<X> supplier) {
        return nutritionFactRepository.findById(id).orElseThrow(supplier);
    }

}
