package com.brainfood.search;

import com.brainfood.search.DBEntities.Recipe;
import com.brainfood.search.DPRepositories.RecipeRepository;
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
    public ShortRecipe[] searchSentence(@RequestParam String sentence) throws JSONException, IOException, InterruptedException {
        System.out.println(sentence);
        JSONArray APIresult = spoonacularAPI.foodText(sentence).getJSONArray("annotations");
        List<ShortRecipe> food = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; !APIresult.isNull(i); i++)
            food.add(mapper.readValue(APIresult.getJSONObject(i).toString(), ShortRecipe.class)) ;

        dishIngredientClassifier.classify(food);
        List<ShortRecipe> dishes = dishIngredientClassifier.getDish();
        List<ShortRecipe> ingredients = dishIngredientClassifier.getIngredient();

        List<Recipe> result = new ArrayList<>();
        result.addAll(recipeDAO.findSimilarDishes(dishes));
        result.addAll(recipeDAO.findByIngredientsLike(ingredients));

        return eliminateDuplicates(result);
    }

    private ShortRecipe[] eliminateDuplicates(List<Recipe> list){
        Set<String> ids = new TreeSet<>();
        List<ShortRecipe> unique = new ArrayList<>() ;
        for(Recipe recipe : list){
            if(!ids.contains(recipe.id)){
                unique.add(new ShortRecipe(recipe));
                ids.add(recipe.id);
            }
        }
        return unique.toArray(new ShortRecipe[unique.size()]);
    }
}