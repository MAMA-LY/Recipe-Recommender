package com.BrainFood.Collectors;

import com.BrainFood.APIsClients.CalorieNinjasClient;
import com.BrainFood.DatabaseEntities.Ingredient;
import com.BrainFood.DatabaseEntities.Recipe;
import com.BrainFood.DatabaseEntities.RecipeIngredients;
import com.BrainFood.DatabaseEntities.RecipeIngredientsCK;
import com.BrainFood.Repositories.IngredientRepository;
import com.BrainFood.Repositories.RecipeIngredientsRepository;
import com.spoonacular.client.model.GetRecipeInformation200ResponseExtendedIngredientsInner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;


public class IngredientCollector {
    @Autowired private IngredientRepository ingredientRepository;
    @Autowired private RecipeIngredientsRepository recipeIngredientsRepository;

    public void collect(GetRecipeInformation200ResponseExtendedIngredientsInner ingredientsInner,
                        Recipe recipe) throws IOException, InterruptedException {

        JSONObject ingredientNutrition = CalorieNinjasClient.getNutrition(ingredientsInner.getOriginal());
        Ingredient ingredient = Ingredient.builder()
                                .name(ingredientsInner.getName())
                                .amount(ingredientsInner.getOriginal())
                                .build();

        ingredientNutritionFitter(ingredient, ingredientNutrition);
        ingredientRepository.save(ingredient);

        RecipeIngredients recipeIngredients = RecipeIngredients
                                              .builder()
                                              .compositeKey(RecipeIngredientsCK
                                                            .builder()
                                                            .recipeID(recipe.getID())
                                                            .ingredientID(ingredient.getID())
                                                            .build())
                                              .build();
        recipeIngredientsRepository.save(recipeIngredients);
    }

    private void ingredientNutritionFitter(Ingredient ingredient,JSONObject nutrition){
        JSONArray items = nutrition.getJSONArray("items");
        JSONObject nutritionFacts = items.getJSONObject(0);
        ingredient.setCalories(((BigDecimal) nutritionFacts.get("calories")).intValue());
        ingredient.setFats(((BigDecimal) nutritionFacts.get("fat_total_g")).intValue());
        ingredient.setProteins(((BigDecimal) nutritionFacts.get("protein_g")).intValue());
        ingredient.setCarbs(((BigDecimal) nutritionFacts.get("carbohydrates_total_g")).intValue());
    }
}
