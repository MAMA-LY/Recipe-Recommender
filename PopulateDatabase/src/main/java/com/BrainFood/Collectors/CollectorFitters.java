package com.BrainFood.Collectors;

import com.BrainFood.DatabaseEntities.Ingredient;
import com.BrainFood.DatabaseEntities.Recipe;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

@NoArgsConstructor
public class CollectorFitters {

    public int getTotalOf(JSONArray items,String nutritionFact) throws JSONException{
        int sum = 0;
        for(int i = 0 ; i < items.length() ; i++) {
            JSONObject nutritionFacts = items.getJSONObject(i);
            if(!nutritionFacts.has(nutritionFact)){
                throw new JSONException("Non-Compatible Keys");
            }
            sum += ((BigDecimal)nutritionFacts.get(nutritionFact)).intValue();
        }
        return sum;
   
    }
    public void recipeNutritionFitter(Recipe recipe, JSONObject nutrition){
        JSONArray items = nutrition.getJSONArray("items");
        recipe.setCalories(getTotalOf(items,"calories"));
        recipe.setFats(getTotalOf(items,"fat_total_g"));
        recipe.setProteins(getTotalOf(items,"protein_g"));
        recipe.setCarbs(getTotalOf(items,"carbohydrates_total_g"));

    }

    public void ingredientNutritionFitter(Ingredient ingredient, JSONObject nutrition){
        JSONArray items = nutrition.getJSONArray("items");
        ingredient.setCalories(getTotalOf(items,"calories"));
        ingredient.setFats(getTotalOf(items,"fat_total_g"));
        ingredient.setProteins(getTotalOf(items,"protein_g"));
        ingredient.setCarbs(getTotalOf(items,"carbohydrates_total_g"));
    }
}
