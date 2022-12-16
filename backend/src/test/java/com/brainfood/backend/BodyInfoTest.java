package com.brainfood.backend;

import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class BodyInfoTest {

    @Test
    void getHeight() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo =new BodyInfo();
        final Field field = bodyInfo.getClass().getDeclaredField("height");
        field.setAccessible(true);
        int expectedValue = 100;
        field.set(bodyInfo, expectedValue);
        assertEquals(expectedValue, bodyInfo.getHeight(), "problem in getHeight");
    }

    @Test
    void getWeight() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo =new BodyInfo();
        final Field field = bodyInfo.getClass().getDeclaredField("weight");
        field.setAccessible(true);
        int expectedValue = 50;
        field.set(bodyInfo, expectedValue);
        assertEquals(expectedValue, bodyInfo.getWeight(), "problem in getWeight");
    }

    @Test
    void getAge() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo =new BodyInfo();
        final Field field = bodyInfo.getClass().getDeclaredField("age");
        field.setAccessible(true);
        int expectedValue = 12;
        field.set(bodyInfo, expectedValue);
        assertEquals(expectedValue, bodyInfo.getAge(), "problem in getAge");
    }

    @Test
    void setHeight() throws NoSuchFieldException, IllegalAccessException {
        final BodyInfo bodyInfo =new BodyInfo();
        bodyInfo.setHeight(120.5f);
        final Field feild=bodyInfo.getClass().getDeclaredField("height");
        feild.setAccessible(true);
        float value= (float)feild.get(bodyInfo);
        assertEquals(120.5,value,"setHeight problem");

    }

    @Test
    void setWeight() throws NoSuchFieldException, IllegalAccessException {
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
    }
}