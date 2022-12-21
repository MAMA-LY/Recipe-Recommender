package com.brainfood.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brainfood.backend.db_entities.Recipe;
import com.brainfood.models.ShortRecipeModel;

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
    public ShortRecipeModel[] searchSentence(@RequestParam String sentence)
            throws JSONException, IOException, InterruptedException {
        List<ShortRecipeModel> food = spoonacularAPI.foodText(sentence);

        dishIngredientClassifier.classify(food);
        List<ShortRecipeModel> dishes = dishIngredientClassifier.getDish();
        List<ShortRecipeModel> ingredients = dishIngredientClassifier.getIngredient();
        System.out.println(sentence + " " + ingredients.size());

        List<Recipe> result = new ArrayList<>();
        result.addAll(recipeDAO.findSimilarDishes(dishes));
        result.addAll(recipeDAO.findByIngredientsLike(ingredients));

        return Utilities.eliminateDuplicates(result);
    }

    @GetMapping("/random")
    public ShortRecipeModel[] getRandom(@RequestParam int number) {
        var result = recipeDAO.getRandomRecipes(number);
        return Utilities.castToArray(result);
    }

    @GetMapping("/withIngredientsAndTags")
    public ShortRecipeModel[] getRecipeWithIngredientsAndTags(@RequestParam String[] Ingredients,
            @RequestParam String[] Tags) {
        var result = recipeDAO.recipesWithIngredients(Ingredients);
        if (result.size() == 0 && Ingredients.length > 0)
            return null;
        result = recipeDAO.filterWithTags(Tags, result);
        return Utilities.castToArray(result);
    }
}