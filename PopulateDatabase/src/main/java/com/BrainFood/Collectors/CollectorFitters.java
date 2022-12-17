package com.BrainFood.Collectors;

import com.BrainFood.DatabaseEntities.Ingredient;
import com.BrainFood.DatabaseEntities.Recipe;
import com.spoonacular.client.model.GetRecipeNutritionWidgetByID200Response;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.relational.core.sql.In;

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
    public void recipeNutritionFitter(Recipe recipe,GetRecipeNutritionWidgetByID200Response nutritionWidgetByID200Response){
        String calories=nutritionWidgetByID200Response.getCalories();
        String fats=nutritionWidgetByID200Response.getFat();
        String proteins=nutritionWidgetByID200Response.getProtein();
        String carbs=nutritionWidgetByID200Response.getCarbs();

        recipe.setCalories((int)Double.parseDouble(calories.substring(0,calories.length()-1)));
        recipe.setFats((int)Double.parseDouble(fats.substring(0,fats.length()-1)));
        recipe.setProteins((int)Double.parseDouble(proteins.substring(0,proteins.length()-1)));
        recipe.setCarbs((int)Double.parseDouble(carbs.substring(0,carbs.length()-1)));
    }

    public void ingredientNutritionFitter(Ingredient ingredient, JSONObject nutrition){
        JSONArray items = nutrition.getJSONArray("items");
        ingredient.setCalories(getTotalOf(items,"calories"));
        ingredient.setFats(getTotalOf(items,"fat_total_g"));
        ingredient.setProteins(getTotalOf(items,"protein_g"));
        ingredient.setCarbs(getTotalOf(items,"carbohydrates_total_g"));
    }
}
