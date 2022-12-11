package com.brainfood.backend;

import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BodyInfoTest {

    static BodyInfo bodyInfo;
    @BeforeAll
    static void setUp() {
        bodyInfo =new BodyInfo(100,50,12);
    }

    @Test
    @Order(1)
    void getHeight() {
        assertEquals(100.0,bodyInfo.getHeight(),"getHeight problem");
    }

    @Test
    @Order(2)
    void getWeight() {
        assertEquals(50.0,bodyInfo.getWeight(),"getWeight problem");
    }

    @Test
    @Order(3)
    void getAge() {
        assertEquals(12,bodyInfo.getAge(),"getAge problem");
    }

    @Test
    @Order(4)
    void setHeight() throws NoSuchFieldException, IllegalAccessException {
        bodyInfo.setHeight(120.5f);
        final Field feild=bodyInfo.getClass().getDeclaredField("height");
        feild.setAccessible(true);
        float value= (float)feild.get(bodyInfo);
        assertEquals(120.5,value,"setHeight problem");

    }

    @Test
    @Order(5)
    void setWeight() throws NoSuchFieldException, IllegalAccessException {
        bodyInfo.setWeight(70.5f);
        final Field feild=bodyInfo.getClass().getDeclaredField("weight");
        feild.setAccessible(true);
        float value= (float)feild.get(bodyInfo);
        assertEquals(70.5,value,"setWeight problem");
    }

    @Test
    @Order(6)
    void setAge() throws NoSuchFieldException, IllegalAccessException {
        bodyInfo.setAge(15);
        final Field feild=bodyInfo.getClass().getDeclaredField("age");
        feild.setAccessible(true);
        int value= (int)feild.get(bodyInfo);
        assertEquals(15,value,"setAge problem");
    }
}