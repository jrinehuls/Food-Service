package com.jrinehuls.foodservice.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "nutrient_uom")
public class NutrientUom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "uom")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Set<Nutrient> nutrients;

}
