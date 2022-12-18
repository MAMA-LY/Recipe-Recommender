package com.brainfood.search;

import com.brainfood.search.DBEntities.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@ComponentScan
@RestController
@RequestMapping("search")
public class SearchController {
    @Autowired
    SpoonacularAPI spoonacularAPI;

    @Autowired
    DishIngredientClassifier dishIngredientClassifier;

    @Autowired
    RecipeDAO recipeDAO;

    @GetMapping("/sentence")
    public ShortRecipe[] searchSentence(@RequestParam String sentence) throws JSONException, IOException, InterruptedException {
        JSONArray APIResult = spoonacularAPI.foodText(sentence).getJSONArray("annotations");
        List<ShortRecipe> food = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; !APIResult.isNull(i); i++)
            food.add(mapper.readValue(APIResult.getJSONObject(i).toString(), ShortRecipe.class)) ;

        dishIngredientClassifier.classify(food);
        List<ShortRecipe> dishes = dishIngredientClassifier.getDish();
        List<ShortRecipe> ingredients = dishIngredientClassifier.getIngredient();

        List<Recipe> result = new ArrayList<>();
        result.addAll(recipeDAO.findSimilarDishes(dishes));
        result.addAll(recipeDAO.findByIngredientsLike(ingredients));

        return Utilities.eliminateDuplicates(result);
    }

    @GetMapping("/random")
    public ShortRecipe[] getRandom(@RequestParam int number){
        var result = recipeDAO.getRandomRecipes(number) ;
        return Utilities.castToArray(result);
    }

    @GetMapping("/withIngredientsAndTags")
    public ShortRecipe[] getRecipeWithIngredientsAndTags(@RequestParam String[] Ingredients , @RequestParam String[] Tags){
        var result = recipeDAO.recipesWithIngredients(Ingredients);
        if (result.size() == 0 && Ingredients.length > 0)
                return null;
        result = recipeDAO.filterWithTags(Tags , result);
        return Utilities.castToArray(result);
    }
}