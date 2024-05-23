package com.jrinehuls.foodservice.service.impl;

import com.jrinehuls.foodservice.exception.notfound.NutrientTypeNotFoundException;
import com.jrinehuls.foodservice.model.dto.nutrient.type.NutrientTypeResponseDto;
import com.jrinehuls.foodservice.model.entity.NutrientType;
import com.jrinehuls.foodservice.repository.NutrientTypeRepository;
import com.jrinehuls.foodservice.util.mapping.nutrient.NutrientTypeMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NutrientTypeServiceImplTest {

    @Mock
    NutrientTypeRepository repository;

    @Mock
    NutrientTypeMapper mapper;

    @Spy
    @InjectMocks
    NutrientTypeServiceImpl nutrientTypeService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createNutrientType() {
    }

    @Test
    void getNutrientTypeById() {
    }

    @Test
    void getNutrientTypeByName_happyPath() {
        // Arrange
        String name = "Protein";
        int id = 1;

        NutrientType nutrientType = new NutrientType();
        nutrientType.setId(id);
        nutrientType.setName(name);

        NutrientTypeResponseDto mockDto = new NutrientTypeResponseDto();
        mockDto.setId(id);
        mockDto.setName(name);

        when(repository.findByNameIgnoreCase(any(String.class))).thenReturn(Optional.of(nutrientType));
        when(mapper.mapNutrientTypeToDto(nutrientType)).thenReturn(mockDto);
        // Act
        NutrientTypeResponseDto responseDto = assertDoesNotThrow(() -> nutrientTypeService.getNutrientType(name));
        // Assert
        verify(repository, times(1)).findByNameIgnoreCase(name);
        assertEquals(id, responseDto.getId());
        assertEquals(name, responseDto.getName());
    }

    @Test
    void getNutrientTypeByName_notFound() {
        // Arrange
        String name = "Protein";
        when(repository.findByNameIgnoreCase(any(String.class))).thenReturn(Optional.empty());
        // Act
        NutrientTypeNotFoundException ex = assertThrows(NutrientTypeNotFoundException.class, () -> nutrientTypeService.getNutrientType(name));
        // Assert
        verify(repository, times(1)).findByNameIgnoreCase(name);
        assertEquals("NutrientType with name " + name + " not found", ex.getMessage());
    }

    @Test
    void getAllNutrientTypes() {
    }

    @Test
    void updateNutrientType() {
    }

    @Test
    void deleteNutrientType() {
    }

    @Test
    void findByIdOrThrow() {
    }

    @Test
    void throwIfExists() {
    }
}