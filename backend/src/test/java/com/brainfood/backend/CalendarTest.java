package com.brainfood.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.brainfood.models.Calendar;
import com.brainfood.models.Ingredient;
import com.brainfood.models.Recipe;

class CalendarTest {

    @Test
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
    void getRecipes() throws NoSuchFieldException, IllegalAccessException {
        final Calendar calendar = new Calendar();
        final Field field = calendar.getClass().getDeclaredField("recipes");
        field.setAccessible(true);
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe());
        field.set(calendar, recipes);

        List<Recipe> result = calendar.getRecipes();

        assertEquals(recipes, result, "problem in getRecipes");
    }

    @Test
    void setIngredients() throws NoSuchFieldException, IllegalAccessException {
        final Calendar calendar = new Calendar();
        final Field field = calendar.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);
        List<Ingredient> ingredientsExpected = new ArrayList<>();

        calendar.setIngredients(ingredientsExpected);

        List<Ingredient> ingredientsActual = (List<Ingredient>) field.get(calendar);
        assertEquals(ingredientsActual, ingredientsExpected, "setIngredients problem");
    }

    @Test
    void setRecipes() throws NoSuchFieldException, IllegalAccessException {
        final Calendar calendar = new Calendar();
        final Field field = calendar.getClass().getDeclaredField("recipes");
        field.setAccessible(true);
        List<Recipe> recipesExpected = new ArrayList<>();

        calendar.setRecipes(recipesExpected);

        List<Recipe> recipesActual = (List<Recipe>) field.get(calendar);
        assertEquals(recipesActual, recipesExpected, "setRecipes problem");

    }
}