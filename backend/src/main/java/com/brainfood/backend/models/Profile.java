package com.brainfood.backend.models;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

import com.brainfood.security.model.UserCredentials;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private UserCredentials userCredentials;

    private List<Recipe> favoriteRecipes;

    private String image;

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
