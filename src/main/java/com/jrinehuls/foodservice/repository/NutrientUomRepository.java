package com.jrinehuls.foodservice.repository;

import com.jrinehuls.foodservice.model.entity.NutrientUom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NutrientUomRepository extends JpaRepository<NutrientUom, Integer> {

    Optional<NutrientUom> findByNameIgnoreCase(String name);

}
