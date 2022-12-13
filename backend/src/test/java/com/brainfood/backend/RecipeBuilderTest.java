package com.brainfood.backend;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeBuilderTest {

    @Test
    void buildID() throws NoSuchFieldException, IllegalAccessException {

        String IDExpected = "id1";
        final Recipe recipe = Recipe.builder().ID(IDExpected).build();

        final Field field = recipe.getClass().getDeclaredField("ID");
        field.setAccessible(true);
        String IDActual= (String) field.get(recipe);

        assertEquals(IDExpected,IDActual, "problem in buildID");
    }

    @Test
    void buildTags() throws NoSuchFieldException, IllegalAccessException {

        List<String> tagsExpected = new ArrayList<>();
        final Recipe recipe = Recipe.builder().tags(tagsExpected).build();

        final Field field = recipe.getClass().getDeclaredField("tags");
        field.setAccessible(true);
        List<String> tagsActual= (List<String>) field.get(recipe);

        assertEquals(tagsExpected,tagsActual, "problem in buildTags");
    }

    @Test
    void buildCuisine() throws NoSuchFieldException, IllegalAccessException {

        String cuisineExpected = "cuisine 41";
        final Recipe recipe = Recipe.builder().cuisine(cuisineExpected).build();

        final Field field = recipe.getClass().getDeclaredField("cuisine");
        field.setAccessible(true);
        String cuisineActual= (String) field.get(recipe);

        assertEquals(cuisineExpected,cuisineActual, "problem in buildCuisine");
    }

    @Test
    void buildName() throws NoSuchFieldException, IllegalAccessException {

        String nameExpected = "cuisine 41";
        final Recipe recipe = Recipe.builder().name(nameExpected).build();

        final Field field = recipe.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String nameActual= (String) field.get(recipe);

        assertEquals(nameExpected,nameActual, "problem in buildName");
    }
    @Test
    void buildIngredients() throws NoSuchFieldException, IllegalAccessException {

        List<Ingredient> ingredientsExpected=new ArrayList<>();
        final Recipe recipe = Recipe.builder().ingredients(ingredientsExpected).build();

        final Field field = recipe.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);
        List<Ingredient> ingredientsActual= (List<Ingredient>) field.get(recipe);

        assertEquals(ingredientsExpected,ingredientsActual, "problem in buildIngredients");
    }
    @Test
    void buildPhoto() throws NoSuchFieldException, IllegalAccessException {

        Image photoExpected = new Image() {
            @Override
            public int getWidth(ImageObserver observer) {
                return 0;
            }

            @Override
            public int getHeight(ImageObserver observer) {
                return 0;
            }

            @Override
            public ImageProducer getSource() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        };
        final Recipe recipe = Recipe.builder().photo(photoExpected).build();

        final Field field = recipe.getClass().getDeclaredField("photo");
        field.setAccessible(true);
        Image photoActual= (Image) field.get(recipe);

        assertEquals(photoExpected,photoActual, "problem in buildPhoto");
    }
    @Test
    void buildNutrition() throws NoSuchFieldException, IllegalAccessException {


        Nutrition nutritionExpected = new Nutrition();
        final Recipe recipe = Recipe.builder().nutrition(nutritionExpected).build();

        final Field field = recipe.getClass().getDeclaredField("nutrition");
        field.setAccessible(true);
        Nutrition nutritionActual= (Nutrition) field.get(recipe);

        assertEquals(nutritionExpected,nutritionActual, "problem in buildNutrition");
    }
}
