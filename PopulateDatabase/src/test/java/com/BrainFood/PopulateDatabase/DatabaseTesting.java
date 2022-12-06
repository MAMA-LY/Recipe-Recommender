package com.BrainFood.PopulateDatabase;

import com.BrainFood.DatabaseEntities.Ingredient;
import com.BrainFood.DatabaseEntities.Recipe;
import com.BrainFood.Repositories.IngredientRepository;
import com.BrainFood.Repositories.RecipeIngredientsRepository;
import com.BrainFood.Repositories.RecipeRepository;
import com.BrainFood.Repositories.RecipeTagsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.testcontainers.containers.MySQLContainer;
//import org.testcontainers.junit.jupiter.Testcontainers;

//@Testcontainers
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DatabaseTesting {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeIngredientsRepository recipeIngredientsRepository;
    @Autowired
    private RecipeTagsRepository recipeTagsRepository;

    Recipe recipe;
    Ingredient ingredient;
//    @BeforeAll
//    static void init() {
//        new MySQLContainer("mysql")
//                .withDatabaseName("test")
//                .withUsername("usr")
//                .withPassword("pass")
//                .start();
//    }
    @Test
    @Order(1)
    public void recipeRepositoryInsertionTest() {
        recipe = Recipe.builder()
                            .name("Pizza")
                            .cuisine("Italy")
                            .photo("https//www.gharipSite.Pizza.png")
                            .calories(300)
                            .carbs(50)
                            .fats(60)
                            .proteins(20)
                            .build();
        Recipe savedRecipe = recipeRepository.save(recipe);
        Assertions.assertEquals(savedRecipe.getName(),recipe.getName());
    }
    @Test
    @Order(2)
    public void recipeRepositoryyDeletionTest() {

        Assertions.assertTrue(recipeRepository.existsRecipeByName(recipe.getName()));
        recipeRepository.delete(recipe);
        Assertions.assertFalse(recipeRepository.existsRecipeByName(recipe.getName()));
    }
    @Test
    @Order(3)
    public void ingredientRepositoryInsertionTest() {
        ingredient = Ingredient.builder()
                                    .name("tomato")
                                    .amount("2 pieces of tomato")
                                    .icon("https//www.gharipSite.tomato.png")
                                    .calories(300)
                                    .carbs(50)
                                    .fats(60)
                                    .proteins(20)
                                    .build();
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        Assertions.assertEquals(savedIngredient.getFats(), ingredient.getFats());
    }


    @Test
    @Order(4)
    public void ingredientRepositoryDeletionTest() {
        Assertions.assertTrue(ingredientRepository.existsIngredientByName(ingredient.getName()));
        ingredientRepository.delete(ingredient);
        Assertions.assertFalse(ingredientRepository.existsIngredientByName(ingredient.getName()));
    }

}

