package com.brainfood.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.brainfood.backend.db_repositories.IngredientRepository;
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
public class DAO {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    IngredientRepository ingredientRepository;

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
        List<RecipeDB> recipeDBS = recipeRepository.findByIngredientsLike("%" + ingredients[0] + "%");
        for (int i = 1; i < ingredients.length; i++) {
            if (recipeDBS.size() == 0)
                return new ArrayList<>();
            recipeDBS = recipeRepository.findByRecipeIngredientsIsLikeAndIdInList("%" + ingredients[i] + "%", recipeDBS);
        }
        return recipeDBS;
    }

    List<RecipeDB> filterWithTags(String[] Tags, List<RecipeDB> currentRecipeDBS) {
        if (Tags.length == 0)
            return currentRecipeDBS;
        if (currentRecipeDBS.size() == 0) {
            currentRecipeDBS = recipeRepository.findRecipeByTag(Tags[0]);
            Tags = Arrays.copyOfRange(Tags, 1, Tags.length);
        }
        for (String tag : Tags) {
            if (currentRecipeDBS.size() == 0)
                return new ArrayList<>();
            currentRecipeDBS = recipeRepository.findRecipeByTagAndIdInList(tag, currentRecipeDBS);
        }
        return currentRecipeDBS;
    }

    public Recipe findRecipe(String id) {
        System.out.println(id);
        RecipeDB recipeDB = recipeRepository.findByIdEquals(id);
        List<IngredientDB> ingredientDBS = recipeRepository.findIngredientsByIdEquals(id);
        List<String> tags = recipeRepository.findTagsByIdEquals(id);

        Recipe recipe = Director.buildRecipe(recipeDB, ingredientDBS, tags);
        return recipe;
    }

    public List<String> getAllIngredients() {
        return ingredientRepository.getDistinctByName();
    }
}
