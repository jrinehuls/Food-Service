package com.jrinehuls.foodservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "nutrient")
@NoArgsConstructor
public class Nutrient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "uom_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "FK__nutrient_uom__nutrient"))
    private NutrientUom uom;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", referencedColumnName = "id",  nullable = false,
            foreignKey = @ForeignKey(name = "FK__nutrient_type__nutrient"))
    private NutrientType type;

    public Nutrient(Double amount, NutrientUom uom, NutrientType type) {
        this.amount = amount;
        this.uom = uom;
        this.type = type;
    }

}
