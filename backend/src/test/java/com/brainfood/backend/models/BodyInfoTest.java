package com.brainfood.backend.models;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BodyInfoTest {

    @Test
    void getHeight() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo = new BodyInfo();
        final Field field = bodyInfo.getClass().getDeclaredField("height");
        field.setAccessible(true);
        int expectedValue = 100;
        field.set(bodyInfo, expectedValue);
        assertEquals(expectedValue, bodyInfo.getHeight(), "problem in getHeight");
    }

    @Test
    void getWeight() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo = new BodyInfo();
        final Field field = bodyInfo.getClass().getDeclaredField("weight");
        field.setAccessible(true);
        int expectedValue = 50;
        field.set(bodyInfo, expectedValue);
        assertEquals(expectedValue, bodyInfo.getWeight(), "problem in getWeight");
    }

    @Test
    void getBirthdate() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo = new BodyInfo();
        Date expectedBirthdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        final Field field = bodyInfo.getClass().getDeclaredField("birthdate");
        field.setAccessible(true);
        field.set(bodyInfo, expectedBirthdate);
        assertEquals(expectedBirthdate, bodyInfo.getBirthdate(), "problem in getBirthdate");
    }

    @Test
    void setHeight() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo = new BodyInfo();
        bodyInfo.setHeight(120.5f);
        final Field field = bodyInfo.getClass().getDeclaredField("height");
        field.setAccessible(true);
        float value = (float) field.get(bodyInfo);
        assertEquals(120.5, value, "setHeight problem");

    }

    @Test
    void setWeight() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo = new BodyInfo();
        bodyInfo.setWeight(70.5f);
        final Field field = bodyInfo.getClass().getDeclaredField("weight");
        field.setAccessible(true);
        float value = (float) field.get(bodyInfo);
        assertEquals(70.5, value, "setWeight problem");
    }

    @Test
    void setBirthdate() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo = new BodyInfo();
        Date expectedBirthdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        bodyInfo.setBirthdate(expectedBirthdate);
        final Field field = bodyInfo.getClass().getDeclaredField("birthdate");
        field.setAccessible(true);
        Date value = (Date) field.get(bodyInfo);
        assertEquals(expectedBirthdate, value, "setBirthdate problem");
    }
}