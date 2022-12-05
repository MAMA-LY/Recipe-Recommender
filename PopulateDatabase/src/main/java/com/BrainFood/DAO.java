package com.BrainFood;

import com.BrainFood.DatabaseEntities.*;
import com.BrainFood.Repositories.IngredientRepository;
import com.BrainFood.Repositories.RecipeIngredientsRepository;
import com.BrainFood.Repositories.RecipeRepository;
import com.BrainFood.Repositories.RecipeTagsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Component
public class DAO {

    @Autowired private RecipeRepository recipeRepository;
    @Autowired private RecipeTagsRepository recipeTagsRepository;
    @Autowired private IngredientRepository ingredientRepository;
    @Autowired private RecipeIngredientsRepository recipeIngredientsRepository;

    public boolean existsRecipe(String recipeName){
        return recipeRepository.existsRecipeByName(recipeName);
    }

    public void saveIntoDB(Recipe recipe, ArrayList<Ingredient> ingredients, List<String> collectedTags){

        recipeRepository.save(recipe);
        for(Ingredient ingredient: ingredients) {
            ingredientRepository.save(ingredient);
            RecipeIngredients recipeIngredients = RecipeIngredients.builder()
                    .compositeKey(RecipeIngredientsCK.builder().recipeID(recipe.getID())
                            .ingredientID(ingredient.getID()).build())
                    .build();
            recipeIngredientsRepository.save(recipeIngredients);
        }
        for (String collectedTag : collectedTags) {
            RecipeTags recipeTags = RecipeTags.builder().compositeKey(RecipeTagsCK.builder()
                    .recipeID(recipe.getID()).tag(collectedTag).build()).build();
            recipeTagsRepository.save(recipeTags);
        }
    }
}
