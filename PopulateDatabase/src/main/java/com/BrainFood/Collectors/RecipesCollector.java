package com.BrainFood.Collectors;

import com.BrainFood.APIsClients.CalorieNinjasClient;
import com.BrainFood.APIsClients.SpoonacularClient;
import com.BrainFood.DatabaseEntities.*;
import com.BrainFood.Repositories.IngredientRepository;
import com.BrainFood.Repositories.RecipeIngredientsRepository;
import com.BrainFood.Repositories.RecipeRepository;
import com.BrainFood.Repositories.RecipeTagsRepository;
import com.spoonacular.client.model.GetRandomRecipes200Response;
import com.spoonacular.client.model.GetRandomRecipes200ResponseRecipesInner;
import com.spoonacular.client.model.GetRecipeInformation200ResponseExtendedIngredientsInner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

@Component
@Order(1)
public class RecipesCollector implements ApplicationRunner {
    @Autowired private RecipeRepository recipeRepository;
    @Autowired private RecipeTagsRepository recipeTagsRepository;
    private final IngredientCollector ingredientCollector = new IngredientCollector();
    private final List<String> tags = Arrays.asList("gluten free", "ketogenic", "vegetarian", "dairy", "dairy free", "seafood", "wheat", "snack",
                                                "breakfast", "dessert", "salad", "main course", "appetizer");
    public void collect() throws IOException, InterruptedException, JSONException {
        SpoonacularClient spoonacularClient = new SpoonacularClient();

        for (String tag: tags) {
            int reqNumber=3 ;//number of recipes in single  request
            GetRandomRecipes200Response recipes = spoonacularClient.getRandomRecipes(reqNumber,tag);
            for (GetRandomRecipes200ResponseRecipesInner recipesInner: recipes.getRecipes()) {

                if(recipeRepository.existsRecipeByName(recipesInner.getTitle()))
                    continue;

                String cuisine;
                if(recipesInner.getCuisines()==null || recipesInner.getCuisines().size() == 0){
                    cuisine = null;
                }else {
                    cuisine = recipesInner.getCuisines().get(0);
                }

                List<String> collectedTags = collectTags(recipesInner);
                JSONObject recipeNutrition = CalorieNinjasClient.getNutrition(recipesInner.getTitle());
                //if nutrition not found get another recipe Note: that should rarely happen
                if (recipeNutrition.getJSONArray("items")==null || recipeNutrition.getJSONArray("items").length()==0)
                    continue;
                Recipe recipe = Recipe
                                .builder()
                                .name(recipesInner.getTitle())
                                .photo(recipesInner.getImage())
                                .cuisine(cuisine)
                                .build();

                recipeNutritionFitter(recipe, recipeNutrition);
                recipeRepository.save(recipe);

                if (recipesInner.getExtendedIngredients() != null){
                    for (GetRecipeInformation200ResponseExtendedIngredientsInner ingredientsInner:
                            recipesInner.getExtendedIngredients()) {
                        ingredientCollector.collect(ingredientsInner, recipe);
                    }
                }
                for (String collectedTag: collectedTags) {
                    RecipeTags recipeTags = RecipeTags.builder().compositeKey(RecipeTagsCK.builder()
                            .recipeID(recipe.getID()).tag(collectedTag).build()).build();
                    recipeTagsRepository.save(recipeTags);
                }
            }
        }
        System.out.println("Complete Collection");
    }

    private void recipeNutritionFitter(Recipe recipe,JSONObject nutrition){
        JSONArray items = nutrition.getJSONArray("items");
        JSONObject nutritionFacts = items.getJSONObject(0);
        recipe.setCalories(((BigDecimal) nutritionFacts.get("calories")).intValue());
        recipe.setFats(((BigDecimal) nutritionFacts.get("fat_total_g")).intValue());
        recipe.setProteins(((BigDecimal) nutritionFacts.get("protein_g")).intValue());
        recipe.setCarbs(((BigDecimal) nutritionFacts.get("carbohydrates_total_g")).intValue());
    }



    private List<String> collectTags(GetRandomRecipes200ResponseRecipesInner recipe){
        return Stream
                .of(recipe.getCuisines(), recipe.getDiets(), recipe.getOccasions(), recipe.getDishTypes())
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .toList();
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        collect();
    }
}
