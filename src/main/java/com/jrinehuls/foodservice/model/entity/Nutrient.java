package com.jrinehuls.foodservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "nutrient")
public class Nutrient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(precision = 2, nullable = false)
    private Double amount;

    @ManyToOne()
    @JoinColumn(name = "type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK__nutrient_type__nutrient"))
    private NutrientType name;

    @ManyToOne()
    @JoinColumn(name = "uom_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK__nutrient_uom__nutrient")) // nullable = true
    private NutrientUom uom;

}
