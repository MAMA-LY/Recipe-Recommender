package com.brainfood.backend;
import java.util.List;
import java.awt.Image;

import com.brainfood.security.Model.UserCredentials;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter @Builder
public class Profile {
    private UserCredentials userCredentials ;

    private List<Recipe> favoriteRecipes;

    private Image photo ;

    private String name;

    private int dailyCalories;

    private int caloriesDate;

    private BodyInfo bodyInfo;

    private Calendar calendar;

    private ProfileBuilder profileBuilder;
    

    //                          Operations                                  

    public void calculateCalories() {
        //
    }
    
    /**
    * @generated
    */
    public void addCalendar() {
        //
    }
    
    
}
