package com.brainfood.backend.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import com.brainfood.backend.db_entities.UserCredentials;


public class ProfileBuilderTest {

    @Test
    void buildBodyInfo() throws NoSuchFieldException, IllegalAccessException {

        BodyInfo bodyInfoExpected = new BodyInfo();
        final Profile profile = Profile.builder().bodyInfo(bodyInfoExpected).build();

        final Field field = profile.getClass().getDeclaredField("bodyInfo");
        field.setAccessible(true);
        BodyInfo bodyInfoActual = (BodyInfo) field.get(profile);

        assertEquals(bodyInfoExpected, bodyInfoActual, "problem in buildBodyInfo");
    }

    @Test
    void buildUserCredentials() throws NoSuchFieldException, IllegalAccessException {


        UserCredentials userCredentialsExpected = new UserCredentials();

        final Profile profile = Profile.builder().userCredentials(userCredentialsExpected).build();

        final Field field = profile.getClass().getDeclaredField("userCredentials");
        field.setAccessible(true);
        UserCredentials userCredentialsActual = (UserCredentials) field.get(profile);

        assertEquals(userCredentialsExpected, userCredentialsActual, "problem in buildUserCredentials");
    }

    @Test
    void buildImage() throws NoSuchFieldException, IllegalAccessException {

        String photoExpected = "https://spoonacular.com/recipeImages/715538-556x370.jpg";
        final Profile profile = Profile.builder().image(photoExpected).build();

        final Field field = profile.getClass().getDeclaredField("image");
        field.setAccessible(true);
        String photoActual = (String) field.get(profile);

        assertEquals(photoExpected, photoActual, "problem in buildPhoto");
    }

    @Test
    void buildName() throws NoSuchFieldException, IllegalAccessException {

        String nameExpected = "name 3";
        final Profile profile = Profile.builder().name(nameExpected).build();

        final Field field = profile.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String nameActual = (String) field.get(profile);

        assertEquals(nameExpected, nameActual, "problem in buildName");
    }

    @Test
    void buildDailyCalories() throws NoSuchFieldException, IllegalAccessException {

        int dailyCaloriesExpected = 3000;
        final Profile profile = Profile.builder().dailyCalories(dailyCaloriesExpected).build();

        final Field field = profile.getClass().getDeclaredField("dailyCalories");
        field.setAccessible(true);
        int dailyCaloriesActual = (int) field.get(profile);

        assertEquals(dailyCaloriesExpected, dailyCaloriesActual, "problem in buildDailyCalories");
    }

    @Test
    void buildCaloriesDate() throws NoSuchFieldException, IllegalAccessException {

        Timestamp caloriesDateExpected = Timestamp.valueOf("2018-09-01 09:01:15");
        final Profile profile = Profile.builder().caloriesDate(caloriesDateExpected).build();

        final Field field = profile.getClass().getDeclaredField("caloriesDate");
        field.setAccessible(true);
        Timestamp caloriesDateActual = (Timestamp) field.get(profile);

        assertEquals(caloriesDateExpected, caloriesDateActual, "problem in buildCaloriesDate");
    }

    @Test
    void buildCalender() throws NoSuchFieldException, IllegalAccessException {

        Calendar calendarExpected = new Calendar();
        final Profile profile = Profile.builder().calendar(calendarExpected).build();

        final Field field = profile.getClass().getDeclaredField("calendar");
        field.setAccessible(true);
        Calendar calendarActual = (Calendar) field.get(profile);

        assertEquals(calendarExpected, calendarActual, "problem in buildCalender");
    }

}
