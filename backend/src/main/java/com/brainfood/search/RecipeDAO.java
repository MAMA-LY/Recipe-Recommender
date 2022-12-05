package com.brainfood.search;

import com.brainfood.search.DBEntities.Recipe;
import com.brainfood.search.DPRepositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeDAO {
    @Autowired
    RecipeRepository recipeRepository;

    List<Recipe> findSimilarDishes(List<ShortRecipe> dishes){
        List<Recipe> result = new ArrayList<>();
        for(ShortRecipe current : dishes){
            var similarDishes = recipeRepository.findByName("%"+current.name+"%") ;
            result.addAll(similarDishes) ;
        }
        return result;
    }

    List<Recipe> findByIngredientsLike(List<ShortRecipe> ingredients){
        List<Recipe> result = new ArrayList<>();
        for(ShortRecipe ingredient : ingredients){
            List<Recipe> dishWithIngredient = recipeRepository.findByIngredientsLike("%"+ingredient.name+"%") ;
            result.addAll(dishWithIngredient) ;
        }
        return result;
    }
}
