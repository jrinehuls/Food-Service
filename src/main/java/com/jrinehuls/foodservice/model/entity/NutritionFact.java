package com.jrinehuls.foodservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "nutrition_fact")
@Getter
@Setter
@NoArgsConstructor
public class NutritionFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serving_size", nullable = false)
    private Integer servingSize;

    @Column(name = "serving_unit", nullable = false)
    private String servingUnit;

    @OneToMany(mappedBy = "nutritionFact")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Nutrient> nutrients;

}
