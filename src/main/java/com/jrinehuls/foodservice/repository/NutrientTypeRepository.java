package com.jrinehuls.foodservice.repository;

import com.jrinehuls.foodservice.model.entity.NutrientType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NutrientTypeRepository extends JpaRepository<NutrientType, Integer> {
    Optional<NutrientType> findByNameIgnoreCase(String name);
}
