package com.brainfood.models;

import lombok.*;

import java.util.List;

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
