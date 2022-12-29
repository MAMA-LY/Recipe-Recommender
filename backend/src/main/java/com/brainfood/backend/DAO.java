package com.brainfood.backend;

import com.brainfood.backend.db_entities.IngredientDB;
import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.backend.db_repositories.IngredientRepository;
import com.brainfood.backend.db_repositories.RecipeRepository;
import com.brainfood.backend.models.Recipe;
import com.brainfood.backend.models.ShortRecipe;
import com.brainfood.backend.models.UserProfile;
import com.brainfood.security.UserAuthenticator;
import com.brainfood.security.model.User;
import com.brainfood.security.model.UserCredentials;
import com.brainfood.security.repository.UserCredentialsRepository;
import com.brainfood.security.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.brainfood.backend.db_entities.IngredientDB;
import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.backend.db_entities.User;
import com.brainfood.backend.db_entities.UserFavRecipes;
import com.brainfood.backend.db_entities.UserFavRecipesCK;
import com.brainfood.backend.db_repositories.IngredientRepository;
import com.brainfood.backend.db_repositories.RecipeRepository;
import com.brainfood.backend.db_repositories.UserFavRecipesRepository;
import com.brainfood.backend.db_repositories.UserRepository;
import com.brainfood.backend.models.Recipe;
import com.brainfood.backend.models.ShortRecipe;
import com.brainfood.security.Response;

@Component
public class DAO {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Autowired
    UserFavRecipesRepository userFavRecipesRepository;

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

    public Recipe findRecipe(String id, String username) {
        System.out.println(id);
        RecipeDB recipeDB = recipeRepository.findByIdEquals(id);
        List<IngredientDB> ingredientDBS = recipeRepository.findIngredientsByIdEquals(id);
        List<String> tags = recipeRepository.findTagsByIdEquals(id);
        List<RecipeDB> favRecipes = this.getFavRecipesByUsername(username);
        return Director.buildRecipe(recipeDB, ingredientDBS, tags, favRecipes.contains(recipeDB));
    }

    public List<String> getAllIngredients() {
        return ingredientRepository.getDistinctByName();
    }


    public UserProfile getUserProfile(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        String email= userCredentialsRepository.findByUsername(username).getEmail();
        UserProfile userProfile = UserProfile.builder().username(username)
                .birthdate(user.getBirthdate())
                .height(user.getHeight())
                .weight(user.getWeight())
                .email(email).build();

        return userProfile;
    }
    public Response addFavRecipeByUsername(String username, String recipeID) {
        User user = userRepository.findByUsername(username);
        String userID = user.getID();
        UserFavRecipes userFavRecipes = new UserFavRecipes();
        userFavRecipes.setCompositeKey(new UserFavRecipesCK(userID, recipeID));
        userFavRecipesRepository.save(userFavRecipes);
        return Response.AddedFavRecipe;
    } 

    public List<RecipeDB> getFavRecipesByUsername(String username) {
        User user = userRepository.findByUsername(username);
        String userID = user.getID();
        List<RecipeDB> recipesFav = userRepository.findFavRecipesById(userID);
        return recipesFav;
    }

    public Response removeFavRecipeByUsername(String username, String recipeID) {
        User user = userRepository.findByUsername(username);
        String userID = user.getID();
        UserFavRecipes userFavRecipes = new UserFavRecipes();
        userFavRecipes.setCompositeKey(new UserFavRecipesCK(userID, recipeID));
        userFavRecipesRepository.delete(userFavRecipes);
        return Response.RemovedFavRecipe;
    }

}
