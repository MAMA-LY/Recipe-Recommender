package com.BrainFood.Collectors;

import com.BrainFood.APIsClients.CalorieNinjasClient;
import com.BrainFood.DatabaseEntities.Ingredient;
import com.spoonacular.client.model.GetRecipeInformation200ResponseExtendedIngredientsInner;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@NoArgsConstructor
public class IngredientCollector {

    private final CollectorFitters collectorFitters = new CollectorFitters();

    public Ingredient collect(GetRecipeInformation200ResponseExtendedIngredientsInner ingredientsInner) {

        JSONObject ingredientNutrition = CalorieNinjasClient.getNutrition(ingredientsInner.getOriginal());
        if(ingredientNutrition.toString().equals("{}")
                || ingredientNutrition.getJSONArray("items")==null
                || ingredientNutrition.getJSONArray("items").length()==0) {
            return null;
        }
        Ingredient ingredient = Ingredient.builder()
                                .name(ingredientsInner.getName())
                                .amount(ingredientsInner.getOriginal())
                                .build();

        collectorFitters.ingredientNutritionFitter(ingredient, ingredientNutrition);
        return ingredient;
    }

}
