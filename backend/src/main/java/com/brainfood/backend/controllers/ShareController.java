package com.brainfood.backend.controllers;

import com.brainfood.backend.db_entities.RecipeRatesCK;
import com.brainfood.backend.db_entities.RecipeRatesDB;
import com.brainfood.backend.db_repositories.RecipeRatesRepository;
import com.brainfood.backend.db_repositories.UserRepository;
import com.brainfood.backend.models.Recipe;
import com.brainfood.backend.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@RestController
@RequestMapping("share")
public class ShareController {

    @Autowired
    DAO dao;

    @Autowired
    RecipeRatesRepository recipeRatesRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("recipe")
    public Recipe getRecipeDetailsByName(@RequestParam(name = "id") String id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.findRecipe(id, username);
    }
}
