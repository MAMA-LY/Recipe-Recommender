package com.brainfood.backend;

<<<<<<< HEAD
=======
import com.brainfood.models.Ingredient;
import com.brainfood.models.Nutrition;
>>>>>>> main
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void getName() throws IllegalAccessException, NoSuchFieldException{
        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String expectedValue = "name1";
        field.set(ingredient, expectedValue);

        assertEquals(expectedValue,ingredient.getName(), "problem in getName");
    }

    @Test
    void getID() throws IllegalAccessException, NoSuchFieldException{

        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("ID");
        field.setAccessible(true);
        String expectedValue = "id1";
        field.set(ingredient, expectedValue);

        assertEquals(expectedValue,ingredient.getID(), "problem in getID");
    }

    @Test
    void getIcon() throws IllegalAccessException, NoSuchFieldException{

        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("icon");
        field.setAccessible(true);
<<<<<<< HEAD
        Image expectedValue = new Image() {
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
=======
        String expectedValue = "icon";
>>>>>>> main
        field.set(ingredient, expectedValue);

        assertEquals(expectedValue,ingredient.getIcon(), "problem in getIcon");
    }

    @Test
    void getWeight() throws IllegalAccessException, NoSuchFieldException{


        final Ingredient ingredient =new Ingredient();
<<<<<<< HEAD
        final Field field = ingredient.getClass().getDeclaredField("weight");
        field.setAccessible(true);
        int expectedValue = 5;
        field.set(ingredient, expectedValue);

        assertEquals(expectedValue,ingredient.getWeight(), "problem in getWeight");
=======
        final Field field = ingredient.getClass().getDeclaredField("amount");
        field.setAccessible(true);
        String expectedValue ="1 egg";
        field.set(ingredient, expectedValue);

        assertEquals(expectedValue,ingredient.getAmount(), "problem in getWeight");
>>>>>>> main
    }

    @Test
    void getNutrition() throws IllegalAccessException, NoSuchFieldException{


        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("nutrition");
        field.setAccessible(true);
        Nutrition expectedValue = new Nutrition();
        field.set(ingredient, expectedValue);

        assertEquals(expectedValue,ingredient.getNutrition(), "problem in getNutrition");
    }

    @Test
    void setName() throws IllegalAccessException, NoSuchFieldException{

        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String expectedValue = "name2";

        ingredient.setName(expectedValue);
        String actualValue= (String)field.get(ingredient);
        assertEquals(expectedValue,actualValue,"problem in setName");

    }

    @Test
    void setID() throws IllegalAccessException, NoSuchFieldException{
        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("ID");
        field.setAccessible(true);
        String expectedValue = "id2";

        ingredient.setID(expectedValue);
        String actualValue= (String)field.get(ingredient);
        assertEquals(expectedValue,actualValue,"problem in setID");
    }

    @Test
    void setIcon() throws IllegalAccessException, NoSuchFieldException{
        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("icon");
        field.setAccessible(true);
<<<<<<< HEAD
        Image expectedValue = new Image() {
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

        ingredient.setIcon(expectedValue);
        Image actualValue= (Image)field.get(ingredient);
=======
        String expectedValue = "https://spoonacular.com/recipeImages/654835-556x370.jpg";
        ingredient.setIcon(expectedValue);
        String actualValue= (String)field.get(ingredient);
>>>>>>> main
        assertEquals(expectedValue,actualValue,"problem in setIcon");
    }

    @Test
<<<<<<< HEAD
    void setWeight() throws IllegalAccessException, NoSuchFieldException{
        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("weight");
        field.setAccessible(true);
        int expectedValue = 101;

        ingredient.setWeight(expectedValue);
        int actualValue= (int)field.get(ingredient);
        assertEquals(expectedValue,actualValue,"problem in setWeight");
=======
    void setAmount() throws IllegalAccessException, NoSuchFieldException{
        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("amount");
        field.setAccessible(true);
        String expectedValue = "1/2 tps";

        ingredient.setAmount(expectedValue);
        String actualValue= (String)field.get(ingredient);
        assertEquals(expectedValue,actualValue,"problem in setAmount");
>>>>>>> main
    }

    @Test
    void setNutrition() throws IllegalAccessException, NoSuchFieldException{
        final Ingredient ingredient =new Ingredient();
        final Field field = ingredient.getClass().getDeclaredField("nutrition");
        field.setAccessible(true);
        Nutrition expectedValue = new Nutrition();

        ingredient.setNutrition(expectedValue);
        Nutrition actualValue= (Nutrition)field.get(ingredient);
        assertEquals(expectedValue,actualValue,"problem in setNutrition");
    }
}