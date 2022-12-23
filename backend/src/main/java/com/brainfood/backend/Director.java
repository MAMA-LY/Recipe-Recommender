package com.brainfood.backend;

import com.brainfood.backend.db_entities.IngredientDB;
import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.backend.models.Ingredient;
import com.brainfood.backend.models.Nutrition;
import com.brainfood.backend.models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class Director {
    public static Nutrition buildRecipeNutritionModel(RecipeDB recipeDB) {
        return Nutrition.builder()
                .calories(recipeDB.calories)
                .carbs(recipeDB.carbs)
                .fats(recipeDB.fats)
                .proteins(recipeDB.proteins)
                .build();
    }

    public static Nutrition buildIngredientNutritionModel(IngredientDB ingredientDB) {
        return Nutrition.builder()
                .calories(ingredientDB.calories)
                .carbs(ingredientDB.carbs)
                .fats(ingredientDB.fats)
                .proteins(ingredientDB.proteins)
                .build();
    }

    public static Ingredient buildIngredientModel(IngredientDB ingredientDB) {
        return Ingredient.builder()
                .icon(ingredientDB.getIcon())
                .ID(ingredientDB.getId())
                .amount(ingredientDB.getAmount())
                .name(ingredientDB.getName())
                .nutrition(buildIngredientNutritionModel(ingredientDB))
                .build();
    }

    public static Recipe buildRecipe(RecipeDB recipeDB, List<IngredientDB> ingredientDBS, List<String> tags) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (IngredientDB ingredientDB : ingredientDBS)
            ingredients.add(buildIngredientModel(ingredientDB));

        return Recipe.builder()
                .ID(recipeDB.id)
                .name(recipeDB.name)
                .cuisine(recipeDB.cuisine)
                .image(recipeDB.photo)
                .nutrition(buildRecipeNutritionModel(recipeDB))
                .ingredients(ingredients)
                .tags(tags)
                .build();
    }
}
