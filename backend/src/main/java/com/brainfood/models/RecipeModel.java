package com.brainfood.models;

import java.util.List;

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
@JsonRootName("Recipe")
public class RecipeModel {

    private String ID;

    private List<String> tags;

    private String cuisine;

    private String name;

    private List<IngredientModel> ingredientModels;

    private String photo;

    private NutritionModel nutritionModel;

}
