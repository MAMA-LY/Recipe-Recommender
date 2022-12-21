package com.brainfood.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brainfood.models.Recipe;

@ComponentScan
@RestController
@RequestMapping("home")
public class HomeController {
    @Autowired
    DAO DAO;

    @GetMapping("recipe")
    public Recipe getRecipeDetails(@RequestParam String id) {
        return DAO.findRecipe(id);
    }

    @GetMapping("ingredients")
    public List<String> getAllIngredients() {
        return DAO.getAllIngredients();
    }

}
