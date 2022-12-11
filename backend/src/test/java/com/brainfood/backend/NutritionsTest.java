package com.brainfood.backend;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class NutritionsTest {

    @Test
    void getCalories() throws IllegalAccessException, NoSuchFieldException {
        final Nutritions nutritions =new Nutritions();
        final Field field = nutritions.getClass().getDeclaredField("calories");
        field.setAccessible(true);
        int expectedValue = 10;
        field.set(nutritions, expectedValue);

        assertEquals(expectedValue,nutritions.getCalories(), "problem in getCalories");
    }

    @Test
    void getProteins() throws IllegalAccessException, NoSuchFieldException {
        final Nutritions nutritions =new Nutritions();
        final Field field = nutritions.getClass().getDeclaredField("proteins");
        field.setAccessible(true);
        int expectedValue = 4;
        field.set(nutritions, expectedValue);
        assertEquals(expectedValue,nutritions.getProteins(), "problem in getProteins");
    }

    @Test
    void getCarbs() throws IllegalAccessException, NoSuchFieldException{
        final Nutritions nutritions =new Nutritions();
        final Field field = nutritions.getClass().getDeclaredField("carbs");
        field.setAccessible(true);
        int expectedValue =123;
        field.set(nutritions, expectedValue);


        assertEquals(expectedValue,nutritions.getCarbs(), "problem in getCarbs");
    }

    @Test
    void getFats() throws IllegalAccessException, NoSuchFieldException{
        final Nutritions nutritions =new Nutritions();
        final Field field = nutritions.getClass().getDeclaredField("fats");
        field.setAccessible(true);
        int expectedValue =42;
        field.set(nutritions, expectedValue);

        assertEquals(expectedValue,nutritions.getFats(), "problem in getFats");
    }

    @Test
    void setCalories() throws IllegalAccessException, NoSuchFieldException{
        final Nutritions nutritions =new Nutritions();
        final Field field =nutritions.getClass().getDeclaredField("calories");
        field.setAccessible(true);

        int expectedValue=13;
        nutritions.setCalories(expectedValue);
        int actualValue= (int)field.get(nutritions);
        assertEquals(expectedValue,actualValue,"problem in setCalories");

    }

    @Test
    void setProteins() throws IllegalAccessException, NoSuchFieldException{
        final Nutritions nutritions =new Nutritions();
        final Field field =nutritions.getClass().getDeclaredField("proteins");
        field.setAccessible(true);

        int expectedValue=13;
        nutritions.setProteins(expectedValue);
        int actualValue= (int)field.get(nutritions);
        assertEquals(expectedValue,actualValue,"problem in setProteins");
    }

    @Test
    void setCarbs() throws IllegalAccessException, NoSuchFieldException{
        final Nutritions nutritions =new Nutritions();
        final Field field =nutritions.getClass().getDeclaredField("carbs");
        field.setAccessible(true);

        int expectedValue=13;
        nutritions.setCarbs(expectedValue);
        int actualValue= (int)field.get(nutritions);
        assertEquals(expectedValue,actualValue,"problem in setCarbs");
    }

    @Test
    void setFats() throws IllegalAccessException, NoSuchFieldException{
        final Nutritions nutritions =new Nutritions();
        final Field field =nutritions.getClass().getDeclaredField("fats");
        field.setAccessible(true);

        int expectedValue=13;
        nutritions.setFats(expectedValue);
        int actualValue= (int)field.get(nutritions);
        assertEquals(expectedValue,actualValue,"problem in setFats");
    }
}