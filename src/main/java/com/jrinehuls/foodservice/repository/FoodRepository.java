package com.jrinehuls.foodservice.repository;

import com.jrinehuls.foodservice.model.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodRepository extends JpaRepository<Food, UUID> {
}
