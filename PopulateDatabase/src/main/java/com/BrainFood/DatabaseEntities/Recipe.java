package com.BrainFood.DatabaseEntities;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Recipe")
@Builder
public class Recipe {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ID", nullable = false)
    private String ID;

    @Column(name = "cuisine", nullable = false)
    private String cuisine ;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "proteins", nullable = false)
    private int proteins;

    @Column(name = "fats", nullable = false)
    private int fats;

    @Column(name = "carbs", nullable = false)
    private int carbs;

    @Column(name = "photo")
    private String photo;



}