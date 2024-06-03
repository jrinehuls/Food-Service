package com.jrinehuls.foodservice.repository;

import com.jrinehuls.foodservice.model.entity.NutritionFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionFactRepository extends JpaRepository<NutritionFact, Long> {
}
