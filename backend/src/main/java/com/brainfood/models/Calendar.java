package com.brainfood.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Calendar {

    private List<IngredientModel> ingredientModels;


    private List<RecipeModel> recipeModels;

    
}
