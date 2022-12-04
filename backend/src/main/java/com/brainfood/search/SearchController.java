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
import java.util.List;

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
        ShortRecipe[] result = new ShortRecipe[size];

        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < result.length; i++)
            result[i] = mapper.readValue(food.getJSONObject(i).toString(), ShortRecipe.class);

        return result;
    }


}