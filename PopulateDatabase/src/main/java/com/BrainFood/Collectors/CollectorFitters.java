package com.BrainFood.Collectors;

import com.BrainFood.DatabaseEntities.Ingredient;
import com.BrainFood.DatabaseEntities.Recipe;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

@NoArgsConstructor
public class CollectorFitters {
    public void recipeNutritionFitter(Recipe recipe, JSONObject nutrition){
        JSONArray items = nutrition.getJSONArray("items");
        JSONObject nutritionFacts = items.getJSONObject(0);
        recipe.setCalories(((BigDecimal) nutritionFacts.get("calories")).intValue());
        recipe.setFats(((BigDecimal) nutritionFacts.get("fat_total_g")).intValue());
        recipe.setProteins(((BigDecimal) nutritionFacts.get("protein_g")).intValue());
        recipe.setCarbs(((BigDecimal) nutritionFacts.get("carbohydrates_total_g")).intValue());
    }

    public void ingredientNutritionFitter(Ingredient ingredient, JSONObject nutrition){
        JSONArray items = nutrition.getJSONArray("items");
        JSONObject nutritionFacts = items.getJSONObject(0);
        ingredient.setCalories(((BigDecimal) nutritionFacts.get("calories")).intValue());
        ingredient.setFats(((BigDecimal) nutritionFacts.get("fat_total_g")).intValue());
        ingredient.setProteins(((BigDecimal) nutritionFacts.get("protein_g")).intValue());
        ingredient.setCarbs(((BigDecimal) nutritionFacts.get("carbohydrates_total_g")).intValue());
    }
}
