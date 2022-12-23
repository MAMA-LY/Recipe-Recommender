package com.brainfood.backend;

<<<<<<< HEAD
import com.brainfood.security.Model.UserCredentials;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

=======
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.lang.reflect.Field;
import java.sql.Timestamp;


import org.junit.jupiter.api.Test;

import com.brainfood.models.BodyInfo;
import com.brainfood.models.Calendar;
import com.brainfood.models.Profile;
import com.brainfood.security.Model.UserCredentials;

import static org.junit.jupiter.api.Assertions.assertEquals;


>>>>>>> main
public class ProfileBuilderTest {

    @Test
    void buildBodyInfo() throws NoSuchFieldException, IllegalAccessException {

<<<<<<< HEAD
        BodyInfo bodyInfoExpected = new BodyInfo() ;
=======
        BodyInfo bodyInfoExpected = new BodyInfo();
>>>>>>> main
        final Profile profile = Profile.builder().bodyInfo(bodyInfoExpected).build();

        final Field field = profile.getClass().getDeclaredField("bodyInfo");
        field.setAccessible(true);
        BodyInfo bodyInfoActual = (BodyInfo) field.get(profile);

<<<<<<< HEAD
        assertEquals(bodyInfoExpected,bodyInfoActual, "problem in buildBodyInfo");
=======
        assertEquals(bodyInfoExpected, bodyInfoActual, "problem in buildBodyInfo");
>>>>>>> main
    }

    @Test
    void buildUserCredentials() throws NoSuchFieldException, IllegalAccessException {

<<<<<<< HEAD
        UserCredentials userCredentialsExpected = new UserCredentials() ;
=======

        UserCredentials userCredentialsExpected = new UserCredentials();

>>>>>>> main
        final Profile profile = Profile.builder().userCredentials(userCredentialsExpected).build();

        final Field field = profile.getClass().getDeclaredField("userCredentials");
        field.setAccessible(true);
        UserCredentials userCredentialsActual = (UserCredentials) field.get(profile);

<<<<<<< HEAD
        assertEquals(userCredentialsExpected,userCredentialsActual, "problem in buildUserCredentials");
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
        final Profile profile = Profile.builder().photo(photoExpected).build();

        final Field field = profile.getClass().getDeclaredField("photo");
        field.setAccessible(true);
        Image photoActual = (Image) field.get(profile);

        assertEquals(photoExpected,photoActual, "problem in buildPhoto");
=======
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
>>>>>>> main
    }

    @Test
    void buildName() throws NoSuchFieldException, IllegalAccessException {

        String nameExpected = "name 3";
        final Profile profile = Profile.builder().name(nameExpected).build();

        final Field field = profile.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String nameActual = (String) field.get(profile);

<<<<<<< HEAD
        assertEquals(nameExpected ,nameActual, "problem in buildName");
    }
    @Test
    void buildDailyCalories() throws NoSuchFieldException, IllegalAccessException {

        int dailyCaloriesExpected = 3000 ;
=======
        assertEquals(nameExpected, nameActual, "problem in buildName");
    }

    @Test
    void buildDailyCalories() throws NoSuchFieldException, IllegalAccessException {

        int dailyCaloriesExpected = 3000;
>>>>>>> main
        final Profile profile = Profile.builder().dailyCalories(dailyCaloriesExpected).build();

        final Field field = profile.getClass().getDeclaredField("dailyCalories");
        field.setAccessible(true);
<<<<<<< HEAD
        int dailyCaloriesActual =(int) field.get(profile);

        assertEquals(dailyCaloriesExpected,dailyCaloriesActual, "problem in buildDailyCalories");
    }
    @Test
    void buildCaloriesDate() throws NoSuchFieldException, IllegalAccessException {

        int caloriesDateExpected = 3000 ;
=======
        int dailyCaloriesActual = (int) field.get(profile);

        assertEquals(dailyCaloriesExpected, dailyCaloriesActual, "problem in buildDailyCalories");
    }

    @Test
    void buildCaloriesDate() throws NoSuchFieldException, IllegalAccessException {

        Timestamp caloriesDateExpected = Timestamp.valueOf("2018-09-01 09:01:15");
>>>>>>> main
        final Profile profile = Profile.builder().caloriesDate(caloriesDateExpected).build();

        final Field field = profile.getClass().getDeclaredField("caloriesDate");
        field.setAccessible(true);
<<<<<<< HEAD
        int caloriesDateActual =(int) field.get(profile);

        assertEquals(caloriesDateExpected,caloriesDateActual, "problem in buildCaloriesDate");
    }
    @Test
    void buildCalender() throws NoSuchFieldException, IllegalAccessException {

        Calendar calendarExpected = new Calendar() ;
=======
        Timestamp caloriesDateActual = (Timestamp) field.get(profile);

        assertEquals(caloriesDateExpected, caloriesDateActual, "problem in buildCaloriesDate");
    }

    @Test
    void buildCalender() throws NoSuchFieldException, IllegalAccessException {

        Calendar calendarExpected = new Calendar();
>>>>>>> main
        final Profile profile = Profile.builder().calendar(calendarExpected).build();

        final Field field = profile.getClass().getDeclaredField("calendar");
        field.setAccessible(true);
        Calendar calendarActual = (Calendar) field.get(profile);

<<<<<<< HEAD
        assertEquals(calendarExpected,calendarActual, "problem in buildCalender");
=======
        assertEquals(calendarExpected, calendarActual, "problem in buildCalender");
>>>>>>> main
    }

}
