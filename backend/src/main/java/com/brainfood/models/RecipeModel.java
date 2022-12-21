package com.brainfood.models;

import java.util.List;

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
public class RecipeModel {

    private String ID;

    private List<String> tags;

    private String cuisine;

    private String name;

    private List<IngredientModel> ingredientModels;

    private String photo;

    private NutritionModel nutritionModel;

}
