package com.brainfood.backend;

import com.brainfood.backend.db_entities.IngredientDB;
import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.backend.db_entities.RecipeRatesCK;
import com.brainfood.backend.db_entities.RecipeRatesDB;
import com.brainfood.backend.db_repositories.IngredientRepository;
import com.brainfood.backend.db_repositories.RecipeRatesRepository;
import com.brainfood.backend.db_repositories.RecipeRepository;
import com.brainfood.backend.models.Recipe;
import com.brainfood.backend.models.ShortRecipe;
import com.brainfood.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DAO {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRatesRepository recipeRatesRepository;

    public List<RecipeDB> findSimilarDishes(List<ShortRecipe> dishes) {
        List<RecipeDB> result = new ArrayList<>();
        for (ShortRecipe current : dishes) {
            var similarDishes = recipeRepository.findByName("%" + current.name + "%");
            result.addAll(similarDishes);
        }
        return result;
    }

    public List<RecipeDB> getRandomRecipes(int quantity) {
        return recipeRepository.randomRecipes(PageRequest.of(0, quantity));
    }

    public List<RecipeDB> findByIngredientsLike(List<ShortRecipe> ingredients) {
        List<RecipeDB> result = new ArrayList<>();
        for (ShortRecipe ingredient : ingredients) {
            List<RecipeDB> dishWithIngredient = recipeRepository.findByIngredientsLike("%" + ingredient.name + "%");
            result.addAll(dishWithIngredient);
        }
        return result;
    }

    public List<RecipeDB> recipesWithIngredients(String[] ingredients) {
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

    public List<RecipeDB> filterWithTags(String[] Tags, List<RecipeDB> currentRecipeDBS) {
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

    public Recipe findRecipe(String id, String userName) {
        System.out.println(id);
        RecipeDB recipeDB = recipeRepository.findByIdEquals(id);
        List<IngredientDB> ingredientDBS = recipeRepository.findIngredientsByIdEquals(id);
        List<String> tags = recipeRepository.findTagsByIdEquals(id);

        String userID = userRepository.findByUsername(userName).getID();
        RecipeRatesDB returned = recipeRatesRepository.findRateForUser(id, userID);
        float userRate = 0;
        if (returned != null)
            userRate = returned.rate;

        return Director.buildRecipe(recipeDB, ingredientDBS, tags, userRate);
    }

    public List<String> getAllIngredients() {
        return ingredientRepository.getDistinctByName();
    }

    public void rateRecipe(String recipeID, String userName, float rate) {
        float oldRate = 0, totalRates;

        String userID = userRepository.findByUsername(userName).getID();
        RecipeRatesDB returned = recipeRatesRepository.findRateForUser(recipeID, userID);

        RecipeDB recipeDB = recipeRepository.findByIdEquals(recipeID);
        totalRates = recipeDB.rates_count * recipeDB.rate;
        recipeDB.rates_count ++ ;

        if (returned != null) {
            recipeDB.rates_count -- ;
            oldRate = returned.rate;
            recipeRatesRepository.delete(returned);
        }

        RecipeRatesDB recipeRatesDB = RecipeRatesDB.builder().rate(rate).
                compositeKey(new RecipeRatesCK(recipeID, userID)).build();
        recipeRatesRepository.save(recipeRatesDB);

        recipeDB.rate = (totalRates - oldRate + rate) / recipeDB.rates_count ;
        recipeRepository.save(recipeDB);
    }
}