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

import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.models.ShortRecipe;

@ComponentScan
@RestController
@RequestMapping("search")
public class SearchController {
    @Autowired
    SpoonacularAPI spoonacularAPI;

    @Autowired
    DishIngredientClassifier dishIngredientClassifier;

    @Autowired
    DAO DAO;

    @GetMapping("/sentence")
    public ShortRecipe[] searchSentence(@RequestParam String sentence)
            throws JSONException, IOException, InterruptedException {
        List<ShortRecipe> food = spoonacularAPI.foodText(sentence);

        dishIngredientClassifier.classify(food);
        List<ShortRecipe> dishes = dishIngredientClassifier.getDish();
        List<ShortRecipe> ingredients = dishIngredientClassifier.getIngredient();
        System.out.println(sentence + " " + ingredients.size());

        List<RecipeDB> result = new ArrayList<>();
        result.addAll(DAO.findSimilarDishes(dishes));
        result.addAll(DAO.findByIngredientsLike(ingredients));

        return Utilities.eliminateDuplicates(result);
    }

    @GetMapping("/random")
    public ShortRecipe[] getRandom(@RequestParam int number) {
        var result = DAO.getRandomRecipes(number);
        return Utilities.castToArray(result);
    }

    @GetMapping("/withIngredientsAndTags")
    public ShortRecipe[] getRecipeWithIngredientsAndTags(@RequestParam String[] Ingredients,
                                                         @RequestParam String[] Tags) {
        var result = DAO.recipesWithIngredients(Ingredients);
        if (result.size() == 0 && Ingredients.length > 0)
            return null;
        result = DAO.filterWithTags(Tags, result);
        return Utilities.castToArray(result);
    }
}