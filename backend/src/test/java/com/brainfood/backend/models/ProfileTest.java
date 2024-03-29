package com.brainfood.backend.models;

import org.junit.jupiter.api.Test;

import com.brainfood.security.model.UserCredentials;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileTest {

    @Test
    void calculateCalories() {
        // to be implemented
    }

    @Test
    void addCalendar() {
        // to be implemented
    }

    @Test
    void getUserCredentials() throws IllegalAccessException, NoSuchFieldException {
        UserCredentials userCredentials = new UserCredentials();
        final Profile profile = new Profile();

        final Field field = profile.getClass().getDeclaredField("userCredentials");
        field.setAccessible(true);
        field.set(profile, userCredentials);

        assertEquals(userCredentials, profile.getUserCredentials(), "problem in getUserCredentials");
    }

    @Test
    void getFavoriteRecipes() throws IllegalAccessException, NoSuchFieldException {

        List<Recipe> favoriteRecipes = new ArrayList<>();


        final Profile profile = new Profile();

        final Field field = profile.getClass().getDeclaredField("favoriteRecipes");
        field.setAccessible(true);
        field.set(profile, favoriteRecipes);

        assertEquals(favoriteRecipes, profile.getFavoriteRecipes(), "problem in getFavoriteRecipes");
    }

    @Test
    void getImage() throws IllegalAccessException, NoSuchFieldException {
        String image = "https://spoonacular.com/recipeImages/649977-556x370.jpg";

        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("image");
        field.setAccessible(true);
        field.set(profile, image);


        assertEquals(image, profile.getImage(), "problem in getImage");

    }

    @Test
    void getName() throws IllegalAccessException, NoSuchFieldException {
        String name = "name";

        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(profile, name);

        assertEquals(name, profile.getName(), "problem in getName");
    }

    @Test
    void getDailyCalories() throws NoSuchFieldException, IllegalAccessException {
        int dailyCalories = 50;

        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("dailyCalories");
        field.setAccessible(true);
        field.set(profile, dailyCalories);

        assertEquals(dailyCalories, profile.getDailyCalories(), "problem in getDailyCalories");
    }

    @Test
    void getCaloriesDate() throws NoSuchFieldException, IllegalAccessException {

        Timestamp caloriesDate = Timestamp.valueOf("2022-09-01 09:01:15");

        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("caloriesDate");
        field.setAccessible(true);
        field.set(profile, caloriesDate);

        assertEquals(caloriesDate, profile.getCaloriesDate(), "problem in getCaloriesDate");
    }

    @Test
    void getBodyInfo() throws IllegalAccessException, NoSuchFieldException {

        BodyInfo bodyInfo = new BodyInfo();

        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("bodyInfo");
        field.setAccessible(true);
        field.set(profile, bodyInfo);

        assertEquals(bodyInfo, profile.getBodyInfo(), "problem in getBodyInfo");
    }

    @Test
    void getCalendar() throws IllegalAccessException, NoSuchFieldException {

        Calendar calendar = new Calendar();

        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("calendar");
        field.setAccessible(true);
        field.set(profile, calendar);

        assertEquals(calendar, profile.getCalendar(), "problem in getCalendar");
    }

    @Test
    void setUserCredentials() throws IllegalAccessException, NoSuchFieldException {

        UserCredentials userCredentials = new UserCredentials();
        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("userCredentials");
        field.setAccessible(true);
        profile.setUserCredentials(userCredentials);

        UserCredentials actual = (UserCredentials) field.get(profile);

        assertEquals(userCredentials, actual, "problem in setUserCredentials");
    }

    @Test
    void setFavoriteRecipes() throws IllegalAccessException, NoSuchFieldException {

        List<Recipe> favoriteRecipes = new ArrayList<>();
        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("favoriteRecipes");
        field.setAccessible(true);
        profile.setFavoriteRecipes(favoriteRecipes);

        List<Recipe> actual = (List<Recipe>) field.get(profile);

        assertEquals(favoriteRecipes, actual, "problem in setFavoriteRecipes");
    }

    @Test
    void setImage() throws IllegalAccessException, NoSuchFieldException {

        String photo = "https://spoonacular.com/recipeImages/649977-556x370.jpg";

        final Profile profile = new Profile();

        final Field field = profile.getClass().getDeclaredField("image");
        field.setAccessible(true);
        profile.setImage(photo);


        String actual = (String) field.get(profile);

        assertEquals(photo, actual, "problem in setImage");

    }

    @Test
    void setName() throws IllegalAccessException, NoSuchFieldException {

        String name = "name 1";
        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("name");
        field.setAccessible(true);
        profile.setName(name);

        String actual = (String) field.get(profile);

        assertEquals(name, actual, "problem in setName");
    }

    @Test
    void setDailyCalories() throws IllegalAccessException, NoSuchFieldException {

        int dailyCalories = 50;
        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("dailyCalories");
        field.setAccessible(true);
        profile.setDailyCalories(dailyCalories);

        int actual = (int) field.get(profile);

        assertEquals(dailyCalories, actual, "problem in setDailyCalories");
    }

    @Test
    void setCaloriesDate() throws IllegalAccessException, NoSuchFieldException {
        Timestamp caloriesDateExpected = Timestamp.valueOf("2020-09-01 09:01:15");
        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("caloriesDate");
        field.setAccessible(true);
        profile.setCaloriesDate(caloriesDateExpected);

        Timestamp actual = (Timestamp) field.get(profile);

        assertEquals(caloriesDateExpected, actual, "problem in setCaloriesDate");
    }

    @Test
    void setBodyInfo() throws IllegalAccessException, NoSuchFieldException {
        BodyInfo bodyInfo = new BodyInfo();
        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("bodyInfo");
        field.setAccessible(true);
        profile.setBodyInfo(bodyInfo);

        BodyInfo actual = (BodyInfo) field.get(profile);

        assertEquals(bodyInfo, actual, "problem in setBodyInfo");
    }

    @Test
    void setCalendar() throws IllegalAccessException, NoSuchFieldException {
        Calendar calendar = new Calendar();
        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("calendar");
        field.setAccessible(true);
        profile.setCalendar(calendar);

        Calendar actual = (Calendar) field.get(profile);

        assertEquals(calendar, actual, "problem in setCalendar");
    }

}