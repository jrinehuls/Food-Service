package com.jrinehuls.foodservice.controller;

import com.jrinehuls.foodservice.service.NutrientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nutrient")
@AllArgsConstructor
public class NutrientController {

    private final NutrientService nutrientService;

    
}
