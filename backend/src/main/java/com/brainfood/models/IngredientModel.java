package com.brainfood.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Ingredient")
public class IngredientModel {

    private String name;

    private String ID;

    private String icon;

    private String amount;

    private NutritionModel nutritionModel;

}
