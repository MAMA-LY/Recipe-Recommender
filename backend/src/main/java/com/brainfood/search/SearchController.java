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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ComponentScan
@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    SpoonacularAPI spoonacularAPI;

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/sentence")
    public ShortRecipe[] searchSentence(@RequestParam String sentence) throws JSONException, IOException, InterruptedException {
        JSONArray food = spoonacularAPI.foodText(sentence).getJSONArray("annotations");
        int size = food.toString().split("annotation").length - 1;
        List<ShortRecipe> result = new ArrayList<>();
        List<ShortRecipe> Ingredients = new ArrayList<>() ;

        ObjectMapper mapper = new ObjectMapper();

        //iterate over all food came from spoonacular
        for (int i = 0; i < size; i++) {
            ShortRecipe current = mapper.readValue(food.getJSONObject(i).toString(), ShortRecipe.class) ;

            //if the food is a dish get similar food like it from database
            if(Objects.equals(current.tag, "dish")){
                var similarDishes = recipeRepository.findByName("%"+current.name+"%") ;
                for (Recipe recipe : similarDishes) {
                    var sr = new ShortRecipe();
                    sr.id = recipe.id;
                    sr.name = recipe.name;
                    sr.image = recipe.photo;
                    result.add(sr) ;
                }

                //if it is an ingredient save it later to get dishes that contain that ingredient
            }else
                Ingredients.add(current) ;
        }

        for(ShortRecipe ingredient : Ingredients){
            List<Recipe> dishWithIngredient = recipeRepository.findByIngredientsLike("%"+ingredient.name+"%") ;
            for (Recipe recipe : dishWithIngredient) {
                var sr = new ShortRecipe();
                sr.id = recipe.id;
                sr.name = recipe.name;
                sr.image = recipe.photo;
                result.add(sr) ;
            }
        }

        return result.toArray(new ShortRecipe[result.size()]);
    }
}