package com.brainfood.backend;

import com.brainfood.security.Model.UserCredentials;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.lang.reflect.Field;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileBuilderTest {

    @Test
    void buildBodyInfo() throws NoSuchFieldException, IllegalAccessException {

        BodyInfo bodyInfoExpected = new BodyInfo() ;
        final Profile profile = Profile.builder().bodyInfo(bodyInfoExpected).build();

        final Field field = profile.getClass().getDeclaredField("bodyInfo");
        field.setAccessible(true);
        BodyInfo bodyInfoActual = (BodyInfo) field.get(profile);

        assertEquals(bodyInfoExpected,bodyInfoActual, "problem in buildBodyInfo");
    }

    @Test
    void buildUserCredentials() throws NoSuchFieldException, IllegalAccessException {

        UserCredentials userCredentialsExpected = new UserCredentials() ;
        final Profile profile = Profile.builder().userCredentials(userCredentialsExpected).build();

        final Field field = profile.getClass().getDeclaredField("userCredentials");
        field.setAccessible(true);
        UserCredentials userCredentialsActual = (UserCredentials) field.get(profile);

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
    }

    @Test
    void buildName() throws NoSuchFieldException, IllegalAccessException {

        String nameExpected = "name 3";
        final Profile profile = Profile.builder().name(nameExpected).build();

        final Field field = profile.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String nameActual = (String) field.get(profile);

        assertEquals(nameExpected ,nameActual, "problem in buildName");
    }
    @Test
    void buildDailyCalories() throws NoSuchFieldException, IllegalAccessException {

        int dailyCaloriesExpected = 3000 ;
        final Profile profile = Profile.builder().dailyCalories(dailyCaloriesExpected).build();

        final Field field = profile.getClass().getDeclaredField("dailyCalories");
        field.setAccessible(true);
        int dailyCaloriesActual =(int) field.get(profile);

        assertEquals(dailyCaloriesExpected,dailyCaloriesActual, "problem in buildDailyCalories");
    }
    @Test
    void buildCaloriesDate() throws NoSuchFieldException, IllegalAccessException {

        Timestamp caloriesDateExpected=Timestamp.valueOf("2018-09-01 09:01:15");
        final Profile profile = Profile.builder().caloriesDate(caloriesDateExpected).build();
        final Field field = profile.getClass().getDeclaredField("caloriesDate");
        field.setAccessible(true);
        Timestamp caloriesDateActual =(Timestamp) field.get(profile);

        assertEquals(caloriesDateExpected,caloriesDateActual, "problem in buildCaloriesDate");
    }
    @Test
    void buildCalender() throws NoSuchFieldException, IllegalAccessException {

        Calendar calendarExpected = new Calendar() ;
        final Profile profile = Profile.builder().calendar(calendarExpected).build();

        final Field field = profile.getClass().getDeclaredField("calendar");
        field.setAccessible(true);
        Calendar calendarActual = (Calendar) field.get(profile);

        assertEquals(calendarExpected,calendarActual, "problem in buildCalender");
    }

}
