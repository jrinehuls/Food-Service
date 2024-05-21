package com.jrinehuls.foodservice.repository;

import com.jrinehuls.foodservice.model.entity.NutrientType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientTypeRepository extends JpaRepository<NutrientType, Integer> {
}
