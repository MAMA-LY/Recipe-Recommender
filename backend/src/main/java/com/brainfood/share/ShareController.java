package com.brainfood.share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brainfood.search.RecipeDAO;
import com.brainfood.search.DBEntities.Recipe;

@ComponentScan
@RestController
@RequestMapping("share")
public class ShareController {

    @Autowired
    RecipeDAO recipeDAO;

    @GetMapping("recipe")
    public Recipe getRecipeDetailsByName(@RequestParam(name = "id") String id) {
        return recipeDAO.findRecipe(id);
    }

}
