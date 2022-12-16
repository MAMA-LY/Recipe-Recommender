package com.brainfood.search;

import com.brainfood.models.RecipeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@RestController
@RequestMapping("home")
public class RecipeController {
    @Autowired
    RecipeDAO recipeDAO;

    @GetMapping("recipe")
    public RecipeModel getRecipeDetails(@RequestParam String id) {
        return recipeDAO.findRecipe(id);
    }
}
