package com.brainfood.backend;

import java.util.List;

import com.brainfood.models.IngredientModel;
import com.brainfood.models.ProfileModel;
import com.brainfood.models.RecipeModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DAO {
    private Database database;


    //                          Operations                                  
    

    public DAO() {
        //
    }

    public boolean loginAuthentication() {
        //
        return false;
    }

    public void addFavRecipe() {
        //
    }

    public List<RecipeModel> getRecipes() {
        //
        return null;
    }

    public RecipeModel getRecipeByID() {
        //
        return null;
    }

    public void deleteFavRecipe() {
        //
    }

    public List<IngredientModel> getAllIngredients() {
        //
        return null;
    }

    public void pushProfile() {
        //
    }

    public ProfileModel getProfile() {
        //
        return null;
    }
    
    
}
