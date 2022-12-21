package com.brainfood.models;

import java.awt.Image;
import java.sql.Timestamp;
import java.util.List;

import com.brainfood.security.Model.UserCredentials;
import com.fasterxml.jackson.annotation.JsonRootName;

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
@JsonRootName("Profile")
public class ProfileModel {
    private UserCredentials userCredentials;

    private List<RecipeModel> favoriteRecipeModels;

    private Image photo;

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
