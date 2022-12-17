package com.BrainFood.Collectors;

import com.BrainFood.APIsClients.SpoonacularClient;
import com.BrainFood.DAO;
import com.BrainFood.DatabaseEntities.*;
import com.spoonacular.client.model.GetRandomRecipes200Response;
import com.spoonacular.client.model.GetRandomRecipes200ResponseRecipesInner;
import com.spoonacular.client.model.GetRecipeInformation200ResponseExtendedIngredientsInner;
import com.spoonacular.client.model.GetRecipeNutritionWidgetByID200Response;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Stream;

@Component
@Order(1)
public class RecipesCollector implements ApplicationRunner {

    @Autowired private  DAO dataAccessObject;
    private final CollectorFitters collectorFitters = new CollectorFitters();
    private final IngredientCollector ingredientCollector = new IngredientCollector();
    private final List<String> tags = Arrays.asList(
            "mediterranean","french","asian","beverage","gluten free", "ketogenic", "vegetarian", "dairy", "dairy free", "seafood", "wheat", "snack",
            "dairy-free","cake","milk","breakfast","dinner", "lunch","dessert", "salad", "main course", "appetizer",
            "primal","paleo","vegan","pescetarian","lacto ovo vegetarian", "whole 30","fall","winter","soup",
            "fodmap friendly","summer","dessert","side dish", "valentine's day","mother's day", "father's day",
            "beverage","appetizer","hor d'oeuvre","4th of july","antipasto"
    );

    public void collect() throws  JSONException {
        SpoonacularClient spoonacularClient = new SpoonacularClient();

        for(String tag : tags) {
            System.out.println("working tag : "+ tag);
            int reqNumber = 100 ;
            GetRandomRecipes200Response recipes200Response =
                    spoonacularClient.getRandomRecipes(reqNumber, tag.toLowerCase());

            for (GetRandomRecipes200ResponseRecipesInner recipesInner: recipes200Response.getRecipes()) {
                GetRecipeNutritionWidgetByID200Response nutritionWidgetByID200Response =spoonacularClient.getRecipeNutritionWidgetByID200Response(recipesInner.getId() );
                if(dataAccessObject.existsRecipe(recipesInner.getTitle()))
                    continue;

                String cuisine;
                if(recipesInner.getCuisines()==null || recipesInner.getCuisines().size() == 0){
                    cuisine = null;
                }else {
                    cuisine = recipesInner.getCuisines().get(0);
                }

                List<String> collectedTags = collectTags(recipesInner);
                Recipe recipe = Recipe
                                .builder()
                                .name(recipesInner.getTitle())
                                .photo(recipesInner.getImage())
                                .cuisine(cuisine)
                                .build();
                collectorFitters.recipeNutritionFitter( recipe, nutritionWidgetByID200Response);

                if (recipesInner.getExtendedIngredients() != null && recipesInner.getExtendedIngredients().size()!=0){
                    boolean completeIngredient = true;
                    ArrayList<Ingredient> ingredients = new ArrayList<>(recipesInner.getExtendedIngredients().size());
                    for (GetRecipeInformation200ResponseExtendedIngredientsInner ingredientsInner:
                            recipesInner.getExtendedIngredients()) {
                        Ingredient ingredient = ingredientCollector.collect(ingredientsInner);
                        if(ingredient != null){
                            ingredients.add(ingredient);
                        }else{
                            completeIngredient = false;
                            break;
                        }
                    }
                    if (!completeIngredient){
                        continue;
                    }
                    dataAccessObject.saveIntoDB(recipe,ingredients,collectedTags);

                }
            }
        }
        System.out.println("Complete Collection");
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
