package com.brainfood.models;


import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Nutrition")
public class NutritionModel {

    private int calories;

    private int proteins;

    private int carbs;

    private int fats;

}
