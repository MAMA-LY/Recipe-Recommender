package com.BrainFood.DatabaseEntities;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Ingredient")
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ID", nullable = false)
    private String ID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "icon")
    private String icon;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "weight")
    private int weight;

    @Column(name = "proteins", nullable = false)
    private int proteins;

    @Column(name = "fats", nullable = false)
    private int fats;

    @Column(name = "carbs")
    private int carbs;







}