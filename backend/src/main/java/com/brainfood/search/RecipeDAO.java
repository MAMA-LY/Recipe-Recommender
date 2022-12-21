package com.brainfood.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.brainfood.backend.Director;
import com.brainfood.backend.db_entities.IngredientDB;
import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.backend.db_repositories.RecipeRepository;
import com.brainfood.models.Recipe;
import com.brainfood.models.ShortRecipe;

@Component
public class RecipeDAO {
    @Autowired
    RecipeRepository recipeRepository;

    List<RecipeDB> findSimilarDishes(List<ShortRecipe> dishes) {
        List<RecipeDB> result = new ArrayList<>();
        for (ShortRecipe current : dishes) {
            var similarDishes = recipeRepository.findByName("%" + current.name + "%");
            result.addAll(similarDishes);
        }
        return result;
    }

    List<RecipeDB> getRandomRecipes(int quantity) {
        return recipeRepository.randomRecipes(PageRequest.of(0, quantity));
    }

    List<RecipeDB> findByIngredientsLike(List<ShortRecipe> ingredients) {
        List<RecipeDB> result = new ArrayList<>();
        for (ShortRecipe ingredient : ingredients) {
            List<RecipeDB> dishWithIngredient = recipeRepository.findByIngredientsLike("%" + ingredient.name + "%");
            result.addAll(dishWithIngredient);
        }
        return result;
    }

    List<RecipeDB> recipesWithIngredients(String[] ingredients) {
        if (ingredients.length == 0)
            return new ArrayList<>();
        List<RecipeDB> recipes = recipeRepository.findByIngredientsLike("%" + ingredients[0] + "%");
        for (int i = 1; i < ingredients.length; i++) {
            if (recipes.size() == 0)
                return new ArrayList<>();
            recipes = recipeRepository.findByRecipeIngredientsIsLikeAndIdInList("%" + ingredients[i] + "%", recipes);
        }
        return recipes;
    }

    List<RecipeDB> filterWithTags(String[] Tags, List<RecipeDB> currentRecipes) {
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

    public Recipe findRecipe(String id) {
        RecipeDB recipe = recipeRepository.findByIdEquals(id);
        List<IngredientDB> ingredients = recipeRepository.findIngredientsByIdEquals(id);
        List<String> tags = recipeRepository.findTagsByIdEquals(id);

        Recipe recipeModel = Director.buildRecipe(recipe, ingredients, tags);
        return recipeModel;
    }

}
