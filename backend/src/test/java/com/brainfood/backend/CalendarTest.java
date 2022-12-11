package com.brainfood.backend;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {

    @Test
    @Order(1)
    void getIngredients() throws NoSuchFieldException, IllegalAccessException {
        final Calendar calendar = new Calendar();
        final Field field = calendar.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        field.set(calendar, ingredients);

        List<Ingredient> result = calendar.getIngredients();

        assertEquals(ingredients, result, "problem in getIngredients");
    }

    @Test
    @Order(2)
    void getRecipes() throws NoSuchFieldException, IllegalAccessException {
        final Calendar calendar = new Calendar();
        final Field field = calendar.getClass().getDeclaredField("recipes");
        field.setAccessible(true);
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe());
        field.set(calendar, recipes);

        List<Recipe> result = calendar.getRecipes();

        assertEquals(recipes, result, "problem in getIngredients");
    }

    @Test
    @Order(3)
    void setIngredients() {

        final Calendar calendar = new Calendar();

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        calendar.setIngredients(ingredients);

        assertEquals(ingredients,calendar.getIngredients(),"setIngredients problem");
    }

    @Test
    @Order(4)
    void setRecipes() throws NoSuchFieldException, IllegalAccessException {
        final Calendar calendar = new Calendar();

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe());
        calendar.setRecipes(recipes);

        assertEquals(recipes,calendar.getRecipes(),"setIngredients problem");
    }
}