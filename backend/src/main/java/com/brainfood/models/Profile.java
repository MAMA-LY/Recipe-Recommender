package com.brainfood.models;

import java.awt.Image;
import java.sql.Timestamp;
import java.util.List;

import com.brainfood.security.Model.UserCredentials;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private UserCredentials userCredentials;

    private List<Recipe> favoriteRecipes;

    private String  image;

    private String name;

    private int dailyCalories;

    private Timestamp caloriesDate;

    private BodyInfo bodyInfo;

    private Calendar calendar;

    // Operations

    public void calculateCalories() {
        //
    }

    public void addCalendar() {
        //
    }

}
