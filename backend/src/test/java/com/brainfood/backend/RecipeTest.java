package com.brainfood.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.brainfood.models.Ingredient;
import com.brainfood.models.Nutrition;
import com.brainfood.models.Recipe;

class RecipeTest {

    @Test
    void getID() throws IllegalAccessException, NoSuchFieldException {
        String IDExpected = "id1";

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("ID");
        field.setAccessible(true);
        field.set(recipe, IDExpected);

        assertEquals(IDExpected, recipe.getID(), "problem in getID");
    }

    @Test
    void getTags() throws IllegalAccessException, NoSuchFieldException {
        List<String> tagsExpected = new ArrayList<>();

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("tags");
        field.setAccessible(true);
        field.set(recipe, tagsExpected);

        assertEquals(tagsExpected, recipe.getTags(), "problem in getTags");

    }

    @Test
    void getCuisine() throws NoSuchFieldException, IllegalAccessException {
        String cuisine = "cuisine1";

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("cuisine");
        field.setAccessible(true);
        field.set(recipe, cuisine);

        assertEquals(cuisine, recipe.getCuisine(), "problem in getCuisine");
    }

    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {
        String name = "name 5";

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(recipe, name);

        assertEquals(name, recipe.getName(), "problem in getName");

    }

    @Test
    void getIngredients() throws NoSuchFieldException, IllegalAccessException {

        List<Ingredient> ingredients = new ArrayList<>();

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);
        field.set(recipe, ingredients);

        assertEquals(ingredients, recipe.getIngredients(), "problem in getIngredients");
    }

    @Test
    void getNutrition() throws NoSuchFieldException, IllegalAccessException {

        Nutrition nutrition = new Nutrition();

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("nutrition");
        field.setAccessible(true);
        field.set(recipe, nutrition);

        assertEquals(nutrition, recipe.getNutrition(), "problem in getNutrition");
    }

    @Test
    void setID() throws IllegalAccessException, NoSuchFieldException {
        String IDExpected = "id1";

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("ID");
        field.setAccessible(true);

        recipe.setID(IDExpected);
        String IDActual = (String) field.get(recipe);
        assertEquals(IDExpected, IDActual, "problem in setID");
    }

    @Test
    void setTags() throws IllegalAccessException, NoSuchFieldException {
        List<String> tagsExpected = new ArrayList<>();

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("tags");
        field.setAccessible(true);

        recipe.setTags(tagsExpected);
        List<String> tagsActual = (List<String>) field.get(recipe);
        assertEquals(tagsExpected, tagsActual, "problem in setTags");
    }

    @Test
    void setCuisine() throws IllegalAccessException, NoSuchFieldException {
        String cuisineExpected = "cuisine12";

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("cuisine");
        field.setAccessible(true);

        recipe.setCuisine(cuisineExpected);
        String cuisineActual = (String) field.get(recipe);
        assertEquals(cuisineExpected, cuisineActual, "problem in setCuisine");
    }

    @Test
    void setName() throws NoSuchFieldException, IllegalAccessException {

        String nameExpected = "name 6";

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("name");
        field.setAccessible(true);

        recipe.setName(nameExpected);
        String nameActual = (String) field.get(recipe);
        assertEquals(nameExpected, nameActual, "problem in setName");
    }

    @Test
    void setIngredients() throws IllegalAccessException, NoSuchFieldException {
        List<Ingredient> ingredientsExpected = new ArrayList<>();

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);

        recipe.setIngredients(ingredientsExpected);
        List<Ingredient> ingredientsActual = (List<Ingredient>) field.get(recipe);
        assertEquals(ingredientsExpected, ingredientsActual, "problem in setIngredients");
    }

    @Test
    void setNutrition() throws NoSuchFieldException, IllegalAccessException {

        Nutrition nutritionExpected = new Nutrition();

        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("nutrition");
        field.setAccessible(true);

        recipe.setNutrition(nutritionExpected);
        Nutrition nutritionActual = (Nutrition) field.get(recipe);
        assertEquals(nutritionExpected, nutritionActual, "problem in setNutrition");
    }
}