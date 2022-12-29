package com.brainfood.backend.controllers;

import com.brainfood.backend.models.Recipe;
import com.brainfood.backend.models.ShortRecipe;
import com.brainfood.backend.utilities.Utilities;
import com.brainfood.security.model.UserFavRecipes;
import com.brainfood.security.model.UserFavRecipesCK;
import com.brainfood.security.repository.UserFavRecipesRepository;
import com.brainfood.security.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.brainfood.backend.DAO;
import com.brainfood.backend.db_entities.RecipeDB;

import java.util.List;

@ComponentScan
@RestController
public class FavController {
    @Autowired
    DAO dao;

    @PostMapping("/fav/recipe/add")
    public String addFav(@RequestParam(name="id") String recipeID) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.addFavRecipeByUsername(username, recipeID).name();
    }


    @GetMapping("/fav/recipe/fetch")
    public ShortRecipe[] getFavIds() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<RecipeDB> recipes = dao.getFavRecipesByUsername(username);
        if(recipes == null) return null;
        ShortRecipe[] shortRecipes = Utilities.castToArray(recipes);
        return shortRecipes;
    }

    @PostMapping("/fav/recipe/remove")
    public String removeFav(@RequestParam(name="id") String recipeID) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.removeFavRecipeByUsername(username, recipeID).name();
    }

 

    

}