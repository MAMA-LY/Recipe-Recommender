package com.BrainFood.DatabaseEntities;

import lombok.Builder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String ID;

    private String cuisine ;

    private String name;

    private int calories;

    private int proteins;

    private int fats;

    private String photo;



}