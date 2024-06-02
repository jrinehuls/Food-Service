package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.badrequest.DuplicateNutrientRequestTypeException;
import com.jrinehuls.foodservice.exception.notfound.NutrientTypeNotFoundException;
import com.jrinehuls.foodservice.exception.notfound.NutrientUomNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrient.NutrientResponseDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactRequestDto;
import com.jrinehuls.foodservice.model.dto.nutrition.NutritionFactResponseDto;
import com.jrinehuls.foodservice.model.entity.Nutrient;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import com.jrinehuls.foodservice.model.entity.NutrientUom;
import com.jrinehuls.foodservice.model.entity.NutritionFact;
import com.jrinehuls.foodservice.repository.NutrientTypeRepository;
import com.jrinehuls.foodservice.repository.NutrientUomRepository;
import com.jrinehuls.foodservice.repository.NutritionFactRepository;
import com.jrinehuls.foodservice.service.NutritionFactService;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NutritionFactServiceImpl implements NutritionFactService {

    private final NutritionFactRepository nutritionFactRepository;
    private final NutrientMapper nutrientMapper;
    private final NutrientUomRepository uomRepository;
    private final NutrientTypeRepository typeRepository;

    // TODO: Create mapper

    @Override
    public NutritionFactResponseDto createNutritionFact(NutritionFactRequestDto requestDto) {
        List<NutrientRequestDto> nutrientRequestDtos = requestDto.getNutrients();
        NutritionFactResponseDto responseDto = new NutritionFactResponseDto();

        if (nutrientRequestDtos.size() > 0) {
            // For each nutrient, check if name repeats. If so, throw exception
            List<String> nutrientTypes = new ArrayList<>();
            for (NutrientRequestDto nutrientRequestDto : nutrientRequestDtos) {
                if (!nutrientTypes.contains(nutrientRequestDto.getType())) {
                    nutrientTypes.add(nutrientRequestDto.getType());
                } else {
                    throw new DuplicateNutrientRequestTypeException(nutrientRequestDto);
                }
            }

            // For each nutrient, check if uom exists. If not, throw exception
            List<NutrientUom> uoms = uomRepository.findAll();
            List<String> uomNames = new ArrayList<>();
            for (NutrientUom uom : uoms) {
                uomNames.add(uom.getName());
            }
            for (NutrientRequestDto nutrientRequestDto : nutrientRequestDtos) {
                if (!uomNames.contains(nutrientRequestDto.getUom())) {
                    throw new NutrientUomNotFoundException("NutrientUom with name " + nutrientRequestDto.getUom() + " not found");
                }
            }

            // For each nutrient, check if type exists. If not, throw exception
            List<NutrientType> types = typeRepository.findAll();
            List<String> typeNames = new ArrayList<>();
            for (NutrientType type : types) {
                typeNames.add(type.getName());
            }
            for (NutrientRequestDto nutrientRequestDto : nutrientRequestDtos) {
                if (!typeNames.contains(nutrientRequestDto.getType())) {
                    throw new NutrientTypeNotFoundException("NutrientType with name " + nutrientRequestDto.getType() + " not found");
                }
            }
            // TODO: Once all checks are successful, save NutritionFact, then all Nutrients
        } else {
            // If nutrient list length == 0, save NutritionFact
            NutritionFact nutritionFact = new NutritionFact();
            nutritionFact.setServingSize(requestDto.getServingSize());
            nutritionFact.setServingUnit(requestDto.getServingUnit());
            nutritionFact.setNutrients(new ArrayList<>());
            NutritionFact saved = nutritionFactRepository.save(nutritionFact);
            responseDto.setId(saved.getId());
            responseDto.setServingSize(saved.getServingSize());
            responseDto.setServingUnit(saved.getServingUnit());
            List<NutrientResponseDto> nutrientResponseDtos = new ArrayList<>();
            for (Nutrient nutrient : saved.getNutrients()) {
                nutrientResponseDtos.add(nutrientMapper.mapNutrientToDto(nutrient));
            }
            responseDto.setNutrients(nutrientResponseDtos);
            return responseDto;
        }


        return null;
    }

}
