package com.brainfood.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.brainfood.models.Nutrition;

class NutritionsTest {

    @Test
    void getCalories() throws IllegalAccessException, NoSuchFieldException {
        final Nutrition nutrition =new Nutrition();
        final Field field = nutrition.getClass().getDeclaredField("calories");
        field.setAccessible(true);
        int expectedValue = 10;
        field.set(nutrition, expectedValue);
        assertEquals(expectedValue, nutrition.getCalories(), "problem in getCalories");
    }

    @Test
    void getProteins() throws IllegalAccessException, NoSuchFieldException {
        final Nutrition nutrition =new Nutrition();
        final Field field = nutrition.getClass().getDeclaredField("proteins");
        field.setAccessible(true);
        int expectedValue = 4;
        field.set(nutrition, expectedValue);
        assertEquals(expectedValue, nutrition.getProteins(), "problem in getProteins");
    }

    @Test
    void getCarbs() throws IllegalAccessException, NoSuchFieldException{
        final Nutrition nutrition =new Nutrition();
        final Field field = nutrition.getClass().getDeclaredField("carbs");
        field.setAccessible(true);
        int expectedValue =123;
        field.set(nutrition, expectedValue);
        assertEquals(expectedValue, nutrition.getCarbs(), "problem in getCarbs");
    }

    @Test
    void getFats() throws IllegalAccessException, NoSuchFieldException{
        final Nutrition nutrition =new Nutrition();
        final Field field = nutrition.getClass().getDeclaredField("fats");
        field.setAccessible(true);
        int expectedValue =42;
        field.set(nutrition, expectedValue);

        assertEquals(expectedValue, nutrition.getFats(), "problem in getFats");
    }

    @Test
    void setCalories() throws IllegalAccessException, NoSuchFieldException{
        final Nutrition nutrition =new Nutrition();
        final Field field = nutrition.getClass().getDeclaredField("calories");
        field.setAccessible(true);

        int expectedValue=13;
        nutrition.setCalories(expectedValue);
        int actualValue= (int)field.get(nutrition);
        assertEquals(expectedValue,actualValue,"problem in setCalories");

    }

    @Test
    void setProteins() throws IllegalAccessException, NoSuchFieldException{
        final Nutrition nutrition =new Nutrition();
        final Field field = nutrition.getClass().getDeclaredField("proteins");
        field.setAccessible(true);

        int expectedValue=13;
        nutrition.setProteins(expectedValue);
        int actualValue= (int)field.get(nutrition);
        assertEquals(expectedValue,actualValue,"problem in setProteins");
    }

    @Test
    void setCarbs() throws IllegalAccessException, NoSuchFieldException{
        final Nutrition nutrition =new Nutrition();
        final Field field = nutrition.getClass().getDeclaredField("carbs");
        field.setAccessible(true);

        int expectedValue=13;
        nutrition.setCarbs(expectedValue);
        int actualValue= (int)field.get(nutrition);
        assertEquals(expectedValue,actualValue,"problem in setCarbs");
    }

    @Test
    void setFats() throws IllegalAccessException, NoSuchFieldException{
        final Nutrition nutrition =new Nutrition();
        final Field field = nutrition.getClass().getDeclaredField("fats");
        field.setAccessible(true);

        int expectedValue=13;
        nutrition.setFats(expectedValue);
        int actualValue= (int)field.get(nutrition);
        assertEquals(expectedValue,actualValue,"problem in setFats");
    }
}