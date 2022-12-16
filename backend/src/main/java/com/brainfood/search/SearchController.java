package com.brainfood.search;

import com.brainfood.models.ShortRecipeModel;
import com.brainfood.backend.db_entities.Recipe;
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
import java.util.*;

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
    public ShortRecipeModel[] searchSentence(@RequestParam String sentence) throws JSONException, IOException, InterruptedException {
        JSONArray APIResult = spoonacularAPI.foodText(sentence).getJSONArray("annotations");
        List<ShortRecipeModel> food = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; !APIResult.isNull(i); i++)
            food.add(mapper.readValue(APIResult.getJSONObject(i).toString(), ShortRecipeModel.class)) ;

        dishIngredientClassifier.classify(food);
        List<ShortRecipeModel> dishes = dishIngredientClassifier.getDish();
        List<ShortRecipeModel> ingredients = dishIngredientClassifier.getIngredient();
        System.out.println(sentence + " " + ingredients.size());

        List<Recipe> result = new ArrayList<>();
        result.addAll(recipeDAO.findSimilarDishes(dishes));
        result.addAll(recipeDAO.findByIngredientsLike(ingredients));

        return eliminateDuplicates(result);
    }

    private ShortRecipeModel[] eliminateDuplicates(List<Recipe> list){
        Set<String> ids = new TreeSet<>();
        List<ShortRecipeModel> unique = new ArrayList<>() ;
        for(Recipe recipe : list){
            if(!ids.contains(recipe.id)){
                unique.add(new ShortRecipeModel(recipe));
                ids.add(recipe.id);
            }
        }
        return unique.toArray(new ShortRecipeModel[unique.size()]);
    }
}