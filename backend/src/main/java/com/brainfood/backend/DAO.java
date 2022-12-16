package com.brainfood.backend;

import java.util.List;

import lombok.Data;
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

    public List<Recipe> getRecipes() {
        //
        return null;
    }

    public Recipe getRecipeByID() {
        //
        return null;
    }

    public void deleteFavRecipe() {
        //
    }

    public List<Ingredient> getAllIngredients() {
        //
        return null;
    }

    public void pushProfile() {
        //
    }

    public Profile getProfile() {
        //
        return null;
    }
    
    
}
