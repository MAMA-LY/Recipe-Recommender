package com.brainfood.backend;

<<<<<<< HEAD
import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import com.brainfood.models.BodyInfo;
>>>>>>> main

class BodyInfoTest {

    @Test
    void getHeight() throws NoSuchFieldException, IllegalAccessException {
<<<<<<< HEAD
        final BodyInfo bodyInfo =new BodyInfo();
=======
        final BodyInfo bodyInfo = new BodyInfo();
>>>>>>> main
        final Field field = bodyInfo.getClass().getDeclaredField("height");
        field.setAccessible(true);
        int expectedValue = 100;
        field.set(bodyInfo, expectedValue);
        assertEquals(expectedValue, bodyInfo.getHeight(), "problem in getHeight");
    }

    @Test
    void getWeight() throws NoSuchFieldException, IllegalAccessException {
<<<<<<< HEAD
        final BodyInfo bodyInfo =new BodyInfo();
=======
        final BodyInfo bodyInfo = new BodyInfo();
>>>>>>> main
        final Field field = bodyInfo.getClass().getDeclaredField("weight");
        field.setAccessible(true);
        int expectedValue = 50;
        field.set(bodyInfo, expectedValue);
        assertEquals(expectedValue, bodyInfo.getWeight(), "problem in getWeight");
    }

    @Test
<<<<<<< HEAD
    void getAge() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo =new BodyInfo();
        final Field field = bodyInfo.getClass().getDeclaredField("age");
        field.setAccessible(true);
        int expectedValue = 12;
        field.set(bodyInfo, expectedValue);
        assertEquals(expectedValue, bodyInfo.getAge(), "problem in getAge");
=======

    void getBirthdate() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo = new BodyInfo();
        Date expectedBirthdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        final Field field = bodyInfo.getClass().getDeclaredField("birthdate");
        field.setAccessible(true);
        field.set(bodyInfo, expectedBirthdate);
        assertEquals(expectedBirthdate, bodyInfo.getBirthdate(), "problem in getBirthdate");
>>>>>>> main
    }

    @Test
    void setHeight() throws NoSuchFieldException, IllegalAccessException {
<<<<<<< HEAD
        final BodyInfo bodyInfo =new BodyInfo();
        bodyInfo.setHeight(120.5f);
        final Field feild=bodyInfo.getClass().getDeclaredField("height");
        feild.setAccessible(true);
        float value= (float)feild.get(bodyInfo);
        assertEquals(120.5,value,"setHeight problem");
=======
        final BodyInfo bodyInfo = new BodyInfo();
        bodyInfo.setHeight(120.5f);
        final Field feild = bodyInfo.getClass().getDeclaredField("height");
        feild.setAccessible(true);
        float value = (float) feild.get(bodyInfo);
        assertEquals(120.5, value, "setHeight problem");
>>>>>>> main

    }

    @Test
    void setWeight() throws NoSuchFieldException, IllegalAccessException {
<<<<<<< HEAD
        final BodyInfo bodyInfo =new BodyInfo();
        bodyInfo.setWeight(70.5f);
        final Field feild=bodyInfo.getClass().getDeclaredField("weight");
        feild.setAccessible(true);
        float value= (float)feild.get(bodyInfo);
        assertEquals(70.5,value,"setWeight problem");
    }

    @Test
    void setAge() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo =new BodyInfo();
        bodyInfo.setAge(15);
        final Field feild=bodyInfo.getClass().getDeclaredField("age");
        feild.setAccessible(true);
        int value= (int)feild.get(bodyInfo);
        assertEquals(15,value,"setAge problem");
=======
        final BodyInfo bodyInfo = new BodyInfo();
        bodyInfo.setWeight(70.5f);
        final Field feild = bodyInfo.getClass().getDeclaredField("weight");
        feild.setAccessible(true);
        float value = (float) feild.get(bodyInfo);
        assertEquals(70.5, value, "setWeight problem");
    }

    @Test

    void setBirthdate() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo = new BodyInfo();
        Date expectedBirthdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        bodyInfo.setBirthdate(expectedBirthdate);
        final Field feild = bodyInfo.getClass().getDeclaredField("birthdate");
        feild.setAccessible(true);
        Date value = (Date) feild.get(bodyInfo);
        assertEquals(expectedBirthdate, value, "setBirthdate problem");
>>>>>>> main
    }
}