package com.jrinehuls.foodservice.repository;

import com.jrinehuls.foodservice.model.entity.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {
}
