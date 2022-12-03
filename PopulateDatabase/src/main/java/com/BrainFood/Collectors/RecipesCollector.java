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
    @Autowired private IngredientRepository ingredientRepository;
    @Autowired private RecipeTagsRepository recipeTagsRepository;
    @Autowired private RecipeIngredientsRepository recipeIngredientsRepository;
    private final List<String> tags = Arrays.asList("gluten free", "ketogenic", "vegetarian", "dairy", "dairy free", "seafood", "wheat", "snack",
                                                "breakfast", "dessert", "salad", "main course", "appetizer");
    public void collect() throws IOException, InterruptedException, JSONException {
        SpoonacularClient spoonacularClient = new SpoonacularClient();
        CollectorFitters collectorFitters=new CollectorFitters();
        for (int k=0;k<100;k++) {
            int reqNumber=10 ;//number of recipes in single  request
            GetRandomRecipes200Response recipes200Response = spoonacularClient.getRandomRecipes(reqNumber, tags.get((int)(Math.random() *tags.size())));
            Recipe[] recipes=new Recipe[reqNumber];
            int i=0;
            for (GetRandomRecipes200ResponseRecipesInner recipesInner: recipes200Response.getRecipes()) {

                if(recipeRepository.existsRecipeByName(recipesInner.getTitle())){
                    continue;
                }
                String cuisine;
                if(recipesInner.getCuisines()==null || recipesInner.getCuisines().size() == 0){
                    cuisine = null;
                }else {
                    cuisine = recipesInner.getCuisines().get(0);
                }

                List<String> collectedTags = collectTags(recipesInner);
                JSONObject recipeNutrition = CalorieNinjasClient.getNutrition(recipesInner.getTitle());
                //if nutritions not found get another recipe Note: that should rarely happen
                if (recipeNutrition.toString().equals("{}")
                        || recipeNutrition.getJSONArray("items")==null
                            || recipeNutrition.getJSONArray("items").length()==0)
                    continue;

                recipes[i] = Recipe.builder().name(recipesInner.getTitle())
                        .photo(recipesInner.getImage()).cuisine(cuisine).build();

                collectorFitters.recipeNutritionFitter( recipes[i], recipeNutrition);
                if (recipesInner.getExtendedIngredients() != null && recipesInner.getExtendedIngredients().size()!=0){
                    boolean ingredientNutritionFlag=false;
                    Ingredient[] ingredients=new Ingredient[recipesInner.getExtendedIngredients().size()];
                    int j=0;
                    for (GetRecipeInformation200ResponseExtendedIngredientsInner ingredientsInner:
                            recipesInner.getExtendedIngredients()) {
                        JSONObject ingredientNutrition = CalorieNinjasClient.getNutrition(ingredientsInner.getOriginal());

                        ingredients[j] = Ingredient.builder().name(ingredientsInner.getName())
                                .amount(ingredientsInner.getOriginal()).build();
                        //if nutritions not found get another recipe Note: that should rarely happen
                        if(ingredientNutrition.toString().equals("{}")
                                || ingredientNutrition.getJSONArray("items")==null
                                    || ingredientNutrition.getJSONArray("items").length()==0) {
                            ingredientNutritionFlag = true;
                            continue;
                        }
                        collectorFitters.ingredientNutritionFitter(ingredients[j], ingredientNutrition);
                        j++;
                    }
                    if(ingredientNutritionFlag==true) // dont save recipe that has unknown certain ingredient nutrition
                        continue;

                    // save all data before fetching other nutritions of the next recipe
                    saveIntoDB(recipes[i],ingredients,collectedTags);
                    i++;
                }

            }
        }
        System.out.println("Complete Collection");
    }

    private void saveIntoDB(Recipe recipe,Ingredient[] ingredients,List<String> collectedTags){

        recipeRepository.save(recipe);  //recipe saved in DB
        for(int i=0;i<ingredients.length;i++) {
            ingredientRepository.save(ingredients[i]);
            RecipeIngredients recipeIngredients = RecipeIngredients.builder()
                    .compositeKey(RecipeIngredientsCK.builder().recipeID(recipe.getID())
                            .ingredientID(ingredients[i].getID()).build())
                    .build();
            recipeIngredientsRepository.save(recipeIngredients);
        }
        for (String collectedTag : collectedTags) {
            RecipeTags recipeTags = RecipeTags.builder().compositeKey(RecipeTagsCK.builder()
                    .recipeID(recipe.getID()).tag(collectedTag).build()).build();
            recipeTagsRepository.save(recipeTags);
        }

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
