package com.BrainFood.Collectors;

import com.BrainFood.DatabaseEntities.Recipe;
import com.BrainFood.Repositories.RecipeIngredientsRepository;
import com.BrainFood.Repositories.RecipeRepository;
import com.BrainFood.Repositories.RecipeTagsRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@Order(1)
public class RecipesCollector implements ApplicationRunner {
    @Autowired private RecipeRepository recipeRepository;
    @Autowired private RecipeTagsRepository recipeTagsRepository;
    @Autowired private RecipeIngredientsRepository recipeIngredientsRepository;

    public void collect() throws IOException, InterruptedException, JSONException {
//        JSONObject result = LowCarbRecipesSwagger.getRandomRecipe();
        Recipe recipe = Recipe.builder()
                .name("flafel")
                .cuisine("egypt")
                .calories(122)
                .proteins(25)
                .fats(33)
                .fats(23)
                .photo("lol")
                .build();
        recipeRepository.save(recipe);
        System.out.println("complete insertion");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        collect();
    }
}
