package com.brainfood.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Calender")
public class Calendar {

    private List<IngredientModel> ingredientModels;

    private List<RecipeModel> recipeModels;

}
