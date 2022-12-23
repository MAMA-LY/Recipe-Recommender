package com.brainfood.backend.controllers;

import com.brainfood.backend.models.Recipe;
import com.brainfood.backend.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

    @GetMapping("recipe")
    public Recipe getRecipeDetailsByName(@RequestParam(name = "id") String id) {
        return dao.findRecipe(id);
    }

}
