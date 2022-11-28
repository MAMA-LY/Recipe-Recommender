package MAMALY.Collectors;

import MAMALY.DatabaseEntities.Recipe;
import MAMALY.Repositories.RecipeIngredientsRepository;
import MAMALY.Repositories.RecipeRepository;
import MAMALY.Repositories.RecipeTagsRepository;
import MAMALY.Swaggers.LowCarbRecipesSwagger;
import MAMALY.Swaggers.SpoonacularSwagger;
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
