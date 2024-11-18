package com.jrinehuls.foodservice.util.mapping.food.config;

import com.jrinehuls.foodservice.util.mapping.food.FoodMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public FoodMapper getFoodMapper() {
        return new FoodMapper();
    }
}
