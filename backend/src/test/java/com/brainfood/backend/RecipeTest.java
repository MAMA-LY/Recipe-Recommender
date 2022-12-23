package com.brainfood.backend;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;

>>>>>>> main
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;
=======
import org.junit.jupiter.api.Test;

import com.brainfood.models.Ingredient;
import com.brainfood.models.Nutrition;
import com.brainfood.models.Recipe;
>>>>>>> main

class RecipeTest {

    @Test
    void getID() throws IllegalAccessException, NoSuchFieldException {
        String IDExpected = "id1";

<<<<<<< HEAD
        final Recipe recipe=new Recipe();
=======
        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("ID");
        field.setAccessible(true);
        field.set(recipe, IDExpected);

<<<<<<< HEAD
        assertEquals(IDExpected,recipe.getID(), "problem in getID");
    }

    @Test
    void getTags()  throws IllegalAccessException, NoSuchFieldException {
        List<String> tagsExpected=new ArrayList<>();

        final Recipe recipe=new Recipe();
=======
        assertEquals(IDExpected, recipe.getID(), "problem in getID");
    }

    @Test
    void getTags() throws IllegalAccessException, NoSuchFieldException {
        List<String> tagsExpected = new ArrayList<>();

        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("tags");
        field.setAccessible(true);
        field.set(recipe, tagsExpected);

<<<<<<< HEAD
        assertEquals(tagsExpected,recipe.getTags(), "problem in getTags");
=======
        assertEquals(tagsExpected, recipe.getTags(), "problem in getTags");
>>>>>>> main

    }

    @Test
    void getCuisine() throws NoSuchFieldException, IllegalAccessException {
<<<<<<< HEAD
        String cuisine ="cuisine1";

        final Recipe recipe=new Recipe();
=======
        String cuisine = "cuisine1";

        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("cuisine");
        field.setAccessible(true);
        field.set(recipe, cuisine);

<<<<<<< HEAD
        assertEquals(cuisine,recipe.getCuisine(), "problem in getCuisine");
=======
        assertEquals(cuisine, recipe.getCuisine(), "problem in getCuisine");
>>>>>>> main
    }

    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {
<<<<<<< HEAD
        String name ="name 5";

        final Recipe recipe=new Recipe();
=======
        String name = "name 5";

        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(recipe, name);

<<<<<<< HEAD
        assertEquals(name,recipe.getName(), "problem in getName");
=======
        assertEquals(name, recipe.getName(), "problem in getName");
>>>>>>> main

    }

    @Test
    void getIngredients() throws NoSuchFieldException, IllegalAccessException {

<<<<<<< HEAD
        List<Ingredient> ingredients=new ArrayList<>();

        final Recipe recipe=new Recipe();
=======
        List<Ingredient> ingredients = new ArrayList<>();

        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);
        field.set(recipe, ingredients);

<<<<<<< HEAD
        assertEquals(ingredients,recipe.getIngredients(), "problem in getIngredients");
    }

    @Test
    void getPhoto()  throws NoSuchFieldException, IllegalAccessException {
        Image image = new Image() {
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

        final Recipe recipe =new Recipe();
        final Field field = recipe.getClass().getDeclaredField("photo");
        field.setAccessible(true);
        field.set(recipe, image);

        assertEquals(image,recipe.getPhoto(), "problem in getPhoto");
    }

=======
        assertEquals(ingredients, recipe.getIngredients(), "problem in getIngredients");
    }


    @Test
    void getImage()  throws NoSuchFieldException, IllegalAccessException {
        String photo ="https://spoonacular.com/recipeImages/654835-556x370.jpg";
        final Recipe recipe =new Recipe();
        final Field field = recipe.getClass().getDeclaredField("image");
        field.setAccessible(true);
        field.set(recipe, photo);

        assertEquals(photo,recipe.getImage(), "problem in getPhoto");
    }


>>>>>>> main
    @Test
    void getNutrition() throws NoSuchFieldException, IllegalAccessException {

        Nutrition nutrition = new Nutrition();

<<<<<<< HEAD
        final Recipe recipe =new Recipe();
=======
        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("nutrition");
        field.setAccessible(true);
        field.set(recipe, nutrition);

<<<<<<< HEAD
        assertEquals(nutrition,recipe.getNutrition(), "problem in getNutrition");
=======
        assertEquals(nutrition, recipe.getNutrition(), "problem in getNutrition");
>>>>>>> main
    }

    @Test
    void setID() throws IllegalAccessException, NoSuchFieldException {
        String IDExpected = "id1";

<<<<<<< HEAD
        final Recipe recipe=new Recipe();
=======
        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("ID");
        field.setAccessible(true);

        recipe.setID(IDExpected);
<<<<<<< HEAD
        String IDActual =(String) field.get(recipe);
        assertEquals(IDExpected,IDActual, "problem in setID");
    }

    @Test
    void setTags()throws IllegalAccessException, NoSuchFieldException {
        List<String> tagsExpected = new ArrayList<>();

        final Recipe recipe=new Recipe();
=======
        String IDActual = (String) field.get(recipe);
        assertEquals(IDExpected, IDActual, "problem in setID");
    }

    @Test
    void setTags() throws IllegalAccessException, NoSuchFieldException {
        List<String> tagsExpected = new ArrayList<>();

        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("tags");
        field.setAccessible(true);

        recipe.setTags(tagsExpected);
<<<<<<< HEAD
        List<String> tagsActual =(List<String>) field.get(recipe);
        assertEquals(tagsExpected,tagsActual, "problem in setTags");
    }

    @Test
    void setCuisine()throws IllegalAccessException, NoSuchFieldException {
        String cuisineExpected = "cuisine12";

        final Recipe recipe=new Recipe();
=======
        List<String> tagsActual = (List<String>) field.get(recipe);
        assertEquals(tagsExpected, tagsActual, "problem in setTags");
    }

    @Test
    void setCuisine() throws IllegalAccessException, NoSuchFieldException {
        String cuisineExpected = "cuisine12";

        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("cuisine");
        field.setAccessible(true);

        recipe.setCuisine(cuisineExpected);
<<<<<<< HEAD
        String cuisineActual =(String) field.get(recipe);
        assertEquals(cuisineExpected,cuisineActual, "problem in setCuisine");
=======
        String cuisineActual = (String) field.get(recipe);
        assertEquals(cuisineExpected, cuisineActual, "problem in setCuisine");
>>>>>>> main
    }

    @Test
    void setName() throws NoSuchFieldException, IllegalAccessException {

        String nameExpected = "name 6";

<<<<<<< HEAD
        final Recipe recipe=new Recipe();
=======
        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("name");
        field.setAccessible(true);

        recipe.setName(nameExpected);
<<<<<<< HEAD
        String nameActual =(String) field.get(recipe);
        assertEquals(nameExpected,nameActual, "problem in setName");
=======
        String nameActual = (String) field.get(recipe);
        assertEquals(nameExpected, nameActual, "problem in setName");
>>>>>>> main
    }

    @Test
    void setIngredients() throws IllegalAccessException, NoSuchFieldException {
        List<Ingredient> ingredientsExpected = new ArrayList<>();

<<<<<<< HEAD
        final Recipe recipe=new Recipe();
=======
        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);

        recipe.setIngredients(ingredientsExpected);
<<<<<<< HEAD
        List<Ingredient> ingredientsActual =(List<Ingredient>) field.get(recipe);
        assertEquals(ingredientsExpected,ingredientsActual, "problem in setIngredients");
    }

    @Test
    void setPhoto() throws NoSuchFieldException, IllegalAccessException {
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

        final Recipe recipe=new Recipe();
        final Field field = recipe.getClass().getDeclaredField("photo");
        field.setAccessible(true);

        recipe.setPhoto(photoExpected);
        Image photoActual =(Image) field.get(recipe);
        assertEquals(photoExpected,photoActual, "problem in setPhoto");
=======
        List<Ingredient> ingredientsActual = (List<Ingredient>) field.get(recipe);
        assertEquals(ingredientsExpected, ingredientsActual, "problem in setIngredients");
    }

    @Test
    void setImage() throws NoSuchFieldException, IllegalAccessException {
        String photoExpected ="https://spoonacular.com/recipeImages/649977-556x370.jpg";
        final Recipe recipe=new Recipe();
        final Field field = recipe.getClass().getDeclaredField("image");
        field.setAccessible(true);

        recipe.setImage(photoExpected);
        String photoActual =(String) field.get(recipe);
        assertEquals(photoExpected,photoActual, "problem in setImage");
>>>>>>> main
    }

    @Test
    void setNutrition() throws NoSuchFieldException, IllegalAccessException {

        Nutrition nutritionExpected = new Nutrition();

<<<<<<< HEAD
        final Recipe recipe=new Recipe();
=======
        final Recipe recipe = new Recipe();
>>>>>>> main
        final Field field = recipe.getClass().getDeclaredField("nutrition");
        field.setAccessible(true);

        recipe.setNutrition(nutritionExpected);
<<<<<<< HEAD
        Nutrition nutritionActual =(Nutrition) field.get(recipe);
=======
        Nutrition nutritionActual = (Nutrition) field.get(recipe);
>>>>>>> main
        assertEquals(nutritionExpected, nutritionActual, "problem in setNutrition");
    }
}