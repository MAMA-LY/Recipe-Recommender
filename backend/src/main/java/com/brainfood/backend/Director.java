package com.brainfood.backend;

import com.brainfood.backend.db_entities.Ingredient;
import com.brainfood.backend.db_entities.Recipe;
import com.brainfood.models.IngredientModel;
import com.brainfood.models.NutritionModel;
import com.brainfood.models.RecipeModel;

import java.util.ArrayList;
import java.util.List;

public class Director {
    public static NutritionModel buildRecipeNutritionModel(Recipe recipe) {
        return NutritionModel.builder()
                .calories(recipe.calories)
                .carbs(recipe.carbs)
                .fats(recipe.fats)
                .proteins(recipe.proteins)
                .build();
    }

    public static NutritionModel buildIngredientNutritionModel(Ingredient ingredient) {
        return NutritionModel.builder()
                .calories(ingredient.calories)
                .carbs(ingredient.carbs)
                .fats(ingredient.fats)
                .proteins(ingredient.proteins)
                .build();
    }

    public static IngredientModel buildIngredientModel(Ingredient ingredient) {
        return IngredientModel.builder()
                .icon(ingredient.getIcon())
                .ID(ingredient.getId())
                .amount(ingredient.getAmount())
                .name(ingredient.getName())
                .nutritionModel(buildIngredientNutritionModel(ingredient))
                .build();
    }


    public static RecipeModel buildRecipe(Recipe recipe, List<Ingredient> ingredients) {
        List<IngredientModel> ingredientModels = new ArrayList<>();
        for (Ingredient ingredient : ingredients)
            ingredientModels.add(buildIngredientModel(ingredient));

        return RecipeModel.builder()
                .ID(recipe.id)
                .name(recipe.name)
                .cuisine(recipe.cuisine)
                .photo(recipe.photo)
                .nutritionModel(buildRecipeNutritionModel(recipe))
                .ingredientModels(ingredientModels)
                .tags(null)
                .build();
    }
}
