package com.brainfood.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brainfood.backend.Director;
import com.brainfood.backend.db_entities.Ingredient;
import com.brainfood.backend.db_entities.Recipe;
import com.brainfood.backend.db_repositories.IngredientRepository;
import com.brainfood.backend.db_repositories.RecipeRepository;
import com.brainfood.models.RecipeModel;
import com.brainfood.models.ShortRecipeModel;
import com.brainfood.security.Repository.PasswordResetTokenRepository;

@Component
public class RecipeDAO {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    List<Recipe> findSimilarDishes(List<ShortRecipeModel> dishes) {
        List<Recipe> result = new ArrayList<>();
        for (ShortRecipeModel current : dishes) {
            var similarDishes = recipeRepository.findByName("%" + current.getName() + "%");
            result.addAll(similarDishes);
        }
        return result;
    }

    List<Recipe> findByIngredientsLike(List<ShortRecipeModel> ingredients) {
        List<Recipe> result = new ArrayList<>();
        System.out.println(" " + ingredients.get(0).getName());
        for (ShortRecipeModel ingredient : ingredients) {
            List<Recipe> dishWithIngredient = recipeRepository.findByIngredientsLike("%" + ingredient.getName() + "%");
            System.out.println(dishWithIngredient.size());
            result.addAll(dishWithIngredient);
        }
        return result;
    }

    RecipeModel findRecipe(String id) {
        Recipe recipe = recipeRepository.findByIdEquals(id);
        List<Ingredient> ingredients = recipeRepository.findIngredientsByIdEquals(id);
        List<String> tags = recipeRepository.findTagsByIdEquals(id);

        RecipeModel recipeModel = Director.buildRecipe(recipe, ingredients, tags);
        return recipeModel;
    }
}
