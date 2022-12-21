package com.brainfood.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.brainfood.backend.Director;
import com.brainfood.backend.db_entities.Ingredient;
import com.brainfood.backend.db_entities.Recipe;
import com.brainfood.backend.db_repositories.RecipeRepository;
import com.brainfood.models.RecipeModel;
import com.brainfood.models.ShortRecipeModel;

@Component
public class RecipeDAO {
    @Autowired
    RecipeRepository recipeRepository;

    List<Recipe> findSimilarDishes(List<ShortRecipeModel> dishes) {
        List<Recipe> result = new ArrayList<>();
        for (ShortRecipeModel current : dishes) {
            var similarDishes = recipeRepository.findByName("%" + current.name + "%");
            result.addAll(similarDishes);
        }
        return result;
    }

    List<Recipe> getRandomRecipes(int quantity) {
        return recipeRepository.randomRecipes(PageRequest.of(0, quantity));
    }

    List<Recipe> findByIngredientsLike(List<ShortRecipeModel> ingredients) {
        List<Recipe> result = new ArrayList<>();
        for (ShortRecipeModel ingredient : ingredients) {
            List<Recipe> dishWithIngredient = recipeRepository.findByIngredientsLike("%" + ingredient.name + "%");
            result.addAll(dishWithIngredient);
        }
        return result;
    }

    List<Recipe> recipesWithIngredients(String[] ingredients) {
        if (ingredients.length == 0)
            return new ArrayList<>();
        List<Recipe> recipes = recipeRepository.findByIngredientsLike("%" + ingredients[0] + "%");
        for (int i = 1; i < ingredients.length; i++) {
            if (recipes.size() == 0)
                return new ArrayList<>();
            recipes = recipeRepository.findByRecipeIngredientsIsLikeAndIdInList("%" + ingredients[i] + "%", recipes);
        }
        return recipes;
    }

    List<Recipe> filterWithTags(String[] Tags, List<Recipe> currentRecipes) {
        if (Tags.length == 0)
            return currentRecipes;
        if (currentRecipes.size() == 0) {
            currentRecipes = recipeRepository.findRecipeByTag(Tags[0]);
            Tags = Arrays.copyOfRange(Tags, 1, Tags.length);
        }
        for (String tag : Tags) {
            if (currentRecipes.size() == 0)
                return new ArrayList<>();
            currentRecipes = recipeRepository.findRecipeByTagAndIdInList(tag, currentRecipes);
        }
        return currentRecipes;
    }

    public RecipeModel findRecipe(String id) {
        Recipe recipe = recipeRepository.findByIdEquals(id);
        List<Ingredient> ingredients = recipeRepository.findIngredientsByIdEquals(id);
        List<String> tags = recipeRepository.findTagsByIdEquals(id);

        RecipeModel recipeModel = Director.buildRecipe(recipe, ingredients, tags);
        return recipeModel;
    }

    public Recipe findRecipeByName(String name) {
        return recipeRepository.findByNameEquals(name);
    }
}
