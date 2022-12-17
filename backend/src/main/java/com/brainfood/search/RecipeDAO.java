package com.brainfood.search;

import com.brainfood.backend.Director;
import com.brainfood.backend.db_entities.Ingredient;
import com.brainfood.backend.db_entities.Recipe;
import com.brainfood.backend.db_entities.RecipeIngredients;
import com.brainfood.backend.db_repositories.IngredientRepository;
import com.brainfood.backend.db_repositories.RecipeIngredientsRepository;
import com.brainfood.backend.db_repositories.RecipeRepository;
import com.brainfood.models.RecipeModel;
import com.brainfood.models.ShortRecipeModel;
import com.brainfood.security.Repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RecipeDAO {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeIngredientsRepository recipeIngredientsRepository;

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    List<Recipe> findSimilarDishes(List<ShortRecipeModel> dishes) {
        List<Recipe> result = new ArrayList<>();
        for (ShortRecipeModel current : dishes) {
            var similarDishes = recipeRepository.findByNameContaining(current.getName());
            result.addAll(similarDishes);
        }
        System.out.println(result.size());
        return result;
    }

    List<Recipe> findByIngredientsLike(List<ShortRecipeModel> ingredients) {
        List<Recipe> result = new ArrayList<>();
        System.out.println(" " + ingredients.get(0).getName());
        for (ShortRecipeModel ingredient : ingredients) {
            List<Recipe> dishWithIngredient = new ArrayList<>();
            System.out.println("JPA");
            List<RecipeIngredients> recipeIngredients = recipeIngredientsRepository.findByIngredientNameLike("%" + ingredient.getName() + "%");
            System.out.println(recipeIngredients.size());
/*
            recipeIngredients.forEach(ri -> dishWithIngredient.add(ri.getRecipe()));
*/
            for(int i = 0; i < recipeIngredients.size(); i++) {
                dishWithIngredient.add(recipeIngredients.get(i).getRecipe());
                System.out.println("adding");
            }
            System.out.println(dishWithIngredient.size());
            result.addAll(dishWithIngredient);
        }
        System.out.println(result.size());
        return result;
    }

    RecipeModel findRecipe(String id) {

        System.out.println(recipeRepository.findByNameContaining("Almond"));
        Recipe recipe = recipeRepository.findRecipeById(id);
        List<RecipeIngredients> recipeIngredients = recipeIngredientsRepository.findByRecipe(recipe);
        List<Ingredient> ingredients = new ArrayList<>();

        for(RecipeIngredients ri : recipeIngredients) {
            ingredients.add(ri.getIngredient());
        }

        List<String> tags = new ArrayList<>();

        RecipeModel recipeModel = Director.buildRecipe(recipe, ingredients);
        return recipeModel;
    }
}
