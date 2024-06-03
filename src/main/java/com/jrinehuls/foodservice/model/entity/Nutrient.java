package com.jrinehuls.foodservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "nutrient", uniqueConstraints = @UniqueConstraint(columnNames = {"type_id", "nutrition_fact_id"}))
@NoArgsConstructor
public class Nutrient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", referencedColumnName = "id",  nullable = false,
            foreignKey = @ForeignKey(name = "FK__nutrient_type__nutrient"))
    private NutrientType nutrientType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nutrition_fact_id", referencedColumnName = "id", nullable = false,
        foreignKey = @ForeignKey(name = "FK__nutrition_fact__nutrient"))
    private NutritionFact nutritionFact;

    public Nutrient(int amount, NutrientType nutrientType, NutritionFact fact) {
        this.amount = amount;
        this.nutrientType = nutrientType;
        this.nutritionFact = fact;
    }

}
