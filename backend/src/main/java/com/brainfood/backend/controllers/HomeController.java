package com.brainfood.backend.controllers;

import com.brainfood.backend.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@ComponentScan
@RestController
@RequestMapping("home")
public class HomeController {
    @Autowired
    com.brainfood.backend.DAO DAO;

    @GetMapping("recipe")
    public Recipe getRecipeDetails(@RequestParam String id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return DAO.findRecipe(id, username);
    }

    @GetMapping("ingredients")
    public List<String> getAllIngredients() {
        return DAO.getAllIngredients();
    }

    @PostMapping("/rateRecipe")
    public Recipe rateRecipe(@RequestParam String recipeID,
                             @RequestParam float rate) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        DAO.rateRecipe(recipeID, userName , rate);
        return DAO.findRecipe(recipeID , userName);
    }
}
