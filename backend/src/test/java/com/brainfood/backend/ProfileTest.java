package com.brainfood.backend;

<<<<<<< HEAD
import com.brainfood.security.Model.UserCredentials;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.brainfood.models.BodyInfo;
import com.brainfood.models.Calendar;
import com.brainfood.models.Profile;
import com.brainfood.models.Recipe;
import com.brainfood.security.Model.UserCredentials;
>>>>>>> main

class ProfileTest {

    @Test
    void calculateCalories() {
<<<<<<< HEAD
        //to be implemented
=======
        // to be implemented
>>>>>>> main
    }

    @Test
    void addCalendar() {
<<<<<<< HEAD
        //to be implemented
=======
        // to be implemented
>>>>>>> main
    }

    @Test
    void getUserCredentials() throws IllegalAccessException, NoSuchFieldException {
        UserCredentials userCredentials = new UserCredentials();
<<<<<<< HEAD
        final Profile profile =new Profile();
=======
        final Profile profile = new Profile();
>>>>>>> main

        final Field field = profile.getClass().getDeclaredField("userCredentials");
        field.setAccessible(true);
        field.set(profile, userCredentials);

<<<<<<< HEAD
        assertEquals(userCredentials,profile.getUserCredentials(), "problem in getUserCredentials");
=======
        assertEquals(userCredentials, profile.getUserCredentials(), "problem in getUserCredentials");
>>>>>>> main
    }

    @Test
    void getFavoriteRecipes() throws IllegalAccessException, NoSuchFieldException {

<<<<<<< HEAD
        List<Recipe> favoriteRecipes= new ArrayList<Recipe>();

        final Profile profile =new Profile();
=======
        List<Recipe> favoriteRecipes = new ArrayList<>();

       

        final Profile profile = new Profile();
>>>>>>> main

        final Field field = profile.getClass().getDeclaredField("favoriteRecipes");
        field.setAccessible(true);
        field.set(profile, favoriteRecipes);

<<<<<<< HEAD
        assertEquals(favoriteRecipes,profile.getFavoriteRecipes(), "problem in getFavoriteRecipes");
    }

    @Test
    void getPhoto() throws IllegalAccessException, NoSuchFieldException {
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

        final Profile profile =new Profile();
        final Field field = profile.getClass().getDeclaredField("photo");
        field.setAccessible(true);
        field.set(profile, image);

        assertEquals(image,profile.getPhoto(), "problem in getPhoto");
=======
        assertEquals(favoriteRecipes, profile.getFavoriteRecipes(), "problem in getFavoriteRecipes");
    }

    @Test
    void getImage() throws IllegalAccessException, NoSuchFieldException {
        String image = "https://spoonacular.com/recipeImages/649977-556x370.jpg";

        final Profile profile = new Profile();
        final Field field = profile.getClass().getDeclaredField("image");
        field.setAccessible(true);
        field.set(profile, image);


        assertEquals(image,profile.getImage(), "problem in getImage");

>>>>>>> main
    }

    @Test
    void getName() throws IllegalAccessException, NoSuchFieldException {
<<<<<<< HEAD
        String name = "name" ;

        final Profile profile =new Profile();
=======
        String name = "name";

        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(profile, name);

<<<<<<< HEAD
        assertEquals(name,profile.getName(), "problem in getName");
=======
        assertEquals(name, profile.getName(), "problem in getName");
>>>>>>> main
    }

    @Test
    void getDailyCalories() throws NoSuchFieldException, IllegalAccessException {
<<<<<<< HEAD
        int dailyCalories = 50 ;

        final Profile profile =new Profile();
=======
        int dailyCalories = 50;

        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("dailyCalories");
        field.setAccessible(true);
        field.set(profile, dailyCalories);

<<<<<<< HEAD
        assertEquals(dailyCalories,profile.getDailyCalories(), "problem in getDailyCalories");
=======
        assertEquals(dailyCalories, profile.getDailyCalories(), "problem in getDailyCalories");
>>>>>>> main
    }

    @Test
    void getCaloriesDate() throws NoSuchFieldException, IllegalAccessException {
<<<<<<< HEAD
        int caloriesDate = 80 ;

        final Profile profile =new Profile();
=======

        Timestamp caloriesDate = Timestamp.valueOf("2022-09-01 09:01:15");

        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("caloriesDate");
        field.setAccessible(true);
        field.set(profile, caloriesDate);

<<<<<<< HEAD
        assertEquals(caloriesDate,profile.getCaloriesDate(), "problem in getCaloriesDate");
=======
        assertEquals(caloriesDate, profile.getCaloriesDate(), "problem in getCaloriesDate");
>>>>>>> main
    }

    @Test
    void getBodyInfo() throws IllegalAccessException, NoSuchFieldException {

<<<<<<< HEAD
        BodyInfo bodyInfo = new BodyInfo() ;

        final Profile profile =new Profile();
=======
        BodyInfo bodyInfo = new BodyInfo();

        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("bodyInfo");
        field.setAccessible(true);
        field.set(profile, bodyInfo);

<<<<<<< HEAD
        assertEquals(bodyInfo,profile.getBodyInfo(), "problem in getBodyInfo");
=======
        assertEquals(bodyInfo, profile.getBodyInfo(), "problem in getBodyInfo");
>>>>>>> main
    }

    @Test
    void getCalendar() throws IllegalAccessException, NoSuchFieldException {

<<<<<<< HEAD
        Calendar calendar = new Calendar() ;

        final Profile profile =new Profile();
=======
        Calendar calendar = new Calendar();

        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("calendar");
        field.setAccessible(true);
        field.set(profile, calendar);

<<<<<<< HEAD
        assertEquals(calendar,profile.getCalendar(), "problem in getCalendar");
=======
        assertEquals(calendar, profile.getCalendar(), "problem in getCalendar");
>>>>>>> main
    }

    @Test
    void setUserCredentials() throws IllegalAccessException, NoSuchFieldException {

        UserCredentials userCredentials = new UserCredentials();
<<<<<<< HEAD
        final Profile profile =new Profile();
=======
        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("userCredentials");
        field.setAccessible(true);
        profile.setUserCredentials(userCredentials);

<<<<<<< HEAD
        UserCredentials actual= (UserCredentials) field.get(profile);

        assertEquals(userCredentials,actual, "problem in setUserCredentials");
=======
        UserCredentials actual = (UserCredentials) field.get(profile);

        assertEquals(userCredentials, actual, "problem in setUserCredentials");
>>>>>>> main
    }

    @Test
    void setFavoriteRecipes() throws IllegalAccessException, NoSuchFieldException {

<<<<<<< HEAD
        List<Recipe> favoriteRecipes=new ArrayList<>();
        final Profile profile =new Profile();
=======
        List<Recipe> favoriteRecipes = new ArrayList<>();
        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("favoriteRecipes");
        field.setAccessible(true);
        profile.setFavoriteRecipes(favoriteRecipes);

<<<<<<< HEAD
        List<Recipe> actual= (List<Recipe>) field.get(profile);

        assertEquals(favoriteRecipes,actual, "problem in setFavoriteRecipes");
    }

    @Test
    void setPhoto() throws IllegalAccessException, NoSuchFieldException {

        Image photo = new Image() {
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
        final Profile profile =new Profile();
        final Field field = profile.getClass().getDeclaredField("photo");
        field.setAccessible(true);
        profile.setPhoto(photo);

        Image actual= (Image) field.get(profile);

        assertEquals(photo,actual, "problem in setPhoto");
    }


=======
        List<Recipe> actual = (List<Recipe>) field.get(profile);

        assertEquals(favoriteRecipes, actual, "problem in setFavoriteRecipes");
    }

    @Test

    void setImage() throws IllegalAccessException, NoSuchFieldException {

        String photo = "https://spoonacular.com/recipeImages/649977-556x370.jpg";

        final Profile profile =new Profile();

        final Field field = profile.getClass().getDeclaredField("image");
        field.setAccessible(true);
        profile.setImage(photo);


        String actual= (String) field.get(profile);

        assertEquals(photo,actual, "problem in setImage");

    }

>>>>>>> main
    @Test
    void setName() throws IllegalAccessException, NoSuchFieldException {

        String name = "name 1";
<<<<<<< HEAD
        final Profile profile =new Profile();
=======
        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("name");
        field.setAccessible(true);
        profile.setName(name);

<<<<<<< HEAD
        String actual= (String) field.get(profile);

        assertEquals(name,actual, "problem in setName");
    }


    @Test
    void setDailyCalories() throws IllegalAccessException, NoSuchFieldException {

        int dailyCalories =  50;
        final Profile profile =new Profile();
=======
        String actual = (String) field.get(profile);

        assertEquals(name, actual, "problem in setName");
    }

    @Test
    void setDailyCalories() throws IllegalAccessException, NoSuchFieldException {

        int dailyCalories = 50;
        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("dailyCalories");
        field.setAccessible(true);
        profile.setDailyCalories(dailyCalories);

<<<<<<< HEAD
        int actual= (int) field.get(profile);

        assertEquals(dailyCalories,actual, "problem in setDailyCalories");
    }


    @Test
    void setCaloriesDate() throws IllegalAccessException, NoSuchFieldException {
        int caloriesDate =  1000;
        final Profile profile =new Profile();
        final Field field = profile.getClass().getDeclaredField("caloriesDate");
        field.setAccessible(true);
        profile.setCaloriesDate(caloriesDate);

        int actual= (int) field.get(profile);

        assertEquals(caloriesDate,actual, "problem in setCaloriesDate");
    }


    @Test
    void setBodyInfo()  throws IllegalAccessException, NoSuchFieldException {
        BodyInfo bodyInfo = new BodyInfo();
        final Profile profile =new Profile();
=======
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
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("bodyInfo");
        field.setAccessible(true);
        profile.setBodyInfo(bodyInfo);

<<<<<<< HEAD
        BodyInfo actual= (BodyInfo) field.get(profile);

        assertEquals(bodyInfo,actual, "problem in setBodyInfo");
=======
        BodyInfo actual = (BodyInfo) field.get(profile);

        assertEquals(bodyInfo, actual, "problem in setBodyInfo");
>>>>>>> main
    }

    @Test
    void setCalendar() throws IllegalAccessException, NoSuchFieldException {
        Calendar calendar = new Calendar();
<<<<<<< HEAD
        final Profile profile =new Profile();
=======
        final Profile profile = new Profile();
>>>>>>> main
        final Field field = profile.getClass().getDeclaredField("calendar");
        field.setAccessible(true);
        profile.setCalendar(calendar);

<<<<<<< HEAD
        Calendar actual= (Calendar) field.get(profile);

        assertEquals(calendar,actual, "problem in setCalendar");
=======
        Calendar actual = (Calendar) field.get(profile);

        assertEquals(calendar, actual, "problem in setCalendar");
>>>>>>> main
    }

}