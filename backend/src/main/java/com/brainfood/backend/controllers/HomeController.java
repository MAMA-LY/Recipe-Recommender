package com.brainfood.backend.controllers;

<<<<<<<< HEAD:backend/src/main/java/com/brainfood/search/HomeController.java
import java.util.List;

========
import com.brainfood.backend.models.Recipe;
>>>>>>>> 48bf27863a2486d300402f525820a56e9208b3a3:backend/src/main/java/com/brainfood/backend/controllers/HomeController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<<< HEAD:backend/src/main/java/com/brainfood/search/HomeController.java
import com.brainfood.models.Recipe;
========
import java.util.List;
>>>>>>>> 48bf27863a2486d300402f525820a56e9208b3a3:backend/src/main/java/com/brainfood/backend/controllers/HomeController.java

@ComponentScan
@RestController
@RequestMapping("home")
public class HomeController {
    @Autowired
<<<<<<<< HEAD:backend/src/main/java/com/brainfood/search/HomeController.java
    DAO DAO;
========
    com.brainfood.backend.DAO DAO;
>>>>>>>> 48bf27863a2486d300402f525820a56e9208b3a3:backend/src/main/java/com/brainfood/backend/controllers/HomeController.java

    @GetMapping("recipe")
    public Recipe getRecipeDetails(@RequestParam String id) {
        return DAO.findRecipe(id);
    }

    @GetMapping("ingredients")
    public List<String> getAllIngredients() {
        return DAO.getAllIngredients();
    }

}
