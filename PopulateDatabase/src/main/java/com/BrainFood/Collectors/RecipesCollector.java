package com.BrainFood.Collectors;

import com.BrainFood.DatabaseEntities.Recipe;
import com.BrainFood.Repositories.RecipeIngredientsRepository;
import com.BrainFood.Repositories.RecipeRepository;
import com.BrainFood.Repositories.RecipeTagsRepository;
import com.BrainFood.Swaggers.LowCarbRecipesSwagger;
import com.BrainFood.Swaggers.SpoonacularSwagger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RecipesCollector {
    private RecipeRepository recipeRepository;
    private RecipeTagsRepository recipeTagsRepository;
    private RecipeIngredientsRepository recipeIngredientsRepository;
    public void collect() throws IOException, InterruptedException, JSONException {
        JSONObject result = LowCarbRecipesSwagger.getRandomRecipe();
//        Recipe recipe = Recipe.builder().name(result.get("title")).cuisine();
//        recipeRepository.save(recipe);
    }

}
