package com.jrinehuls.foodservice.repository;

import com.jrinehuls.foodservice.model.entity.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {
    Optional<Nutrient> findByNutrientTypeIdAndNutritionFactId(int nutrientType, long nutritionFact);
}
