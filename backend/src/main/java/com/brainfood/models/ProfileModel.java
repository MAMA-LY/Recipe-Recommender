package com.brainfood.models;
import java.util.List;
import java.awt.Image;
import java.sql.Timestamp;

import com.brainfood.security.Model.UserCredentials;
import lombok.*;


@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class ProfileModel {
    private UserCredentials userCredentials ;

    private List<RecipeModel> favoriteRecipeModels;

    private Image photo ;

    private String name;

    private int dailyCalories;

    private Timestamp caloriesDate;

    private BodyInfo bodyInfo;

    private Calendar calendar;


    //                          Operations                                  

    public void calculateCalories() {
        //
    }

    public void addCalendar() {
        //
    }
    
    
}
