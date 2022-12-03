package com.brainfood.backend;
import java.util.List;

import com.brainfood.security.Model.UserCredentials;

/**
* @generated
*/
public class Profile {
    
    /**
    * @generated
    */
    private UserCredentials userCredentials ;
    
    /**
    * @generated
    */
    private List<Recipe> favoriteRecipes;
    
    /**
    * @generated
    */
    private Image photo ;
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private int dailyCalories;
    
    /**
    * @generated
    */
    private int caloriesDate;
    
    /**
    * @generated
    */
    private BodyInfo bodyInfo;
    
    /**
    * @generated
    */
    private Calendar calendar;
    
    
    /**
    * @generated
    */
    private ProfileBuilder profileBuilder;
    
    

    /**
    * @generated
    */
    public UserCredentials getUserCredentials () {
        return this.userCredentials ;
    }
    
    /**
    * @generated
    */
    public void setUserCredentials(UserCredentials userCredentials ) {
        this.userCredentials  = userCredentials ;
    }
    
    
    /**
    * @generated
    */
    public List<Recipe> getFavoriteRecipes() {
        return this.favoriteRecipes;
    }
    
    /**
    * @generated
    */
    public void setFavoriteRecipes(List<Recipe> favoriteRecipes) {
        this.favoriteRecipes = favoriteRecipes;
    }
    
    
    /**
    * @generated
    */
    public Image getPhoto () {
        return this.photo ;
    }
    
    /**
    * @generated
    */
    public void setPhoto (Image photo ) {
        this.photo  = photo ;
    }
    
    
    /**
    * @generated
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
    * @generated
    */
    public int getDailyCalories() {
        return this.dailyCalories;
    }
    
    /**
    * @generated
    */
    public void setDailyCalories(Integer dailyCalories) {
        this.dailyCalories = dailyCalories;
    }
    
    
    /**
    * @generated
    */
    public int getCaloriesDate() {
        return this.caloriesDate;
    }
    
    /**
    * @generated
    */
    public void setCaloriesDate(Integer caloriesDate) {
        this.caloriesDate = caloriesDate;
    }
    
    
    /**
    * @generated
    */
    public BodyInfo getBodyInfo() {
        return this.bodyInfo;
    }
    
    /**
    * @generated
    */
    public void setBodyInfo(BodyInfo bodyInfo) {
        this.bodyInfo = bodyInfo;
    }
    
    
    /**
    * @generated
    */
    public Calendar getCalendar() {
        return this.calendar;
    }
    
    /**
    * @generated
    */
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    
    
    
    /**
    * @generated
    */
    public ProfileBuilder getProfileBuilder() {
        return this.profileBuilder;
    }
    
    /**
    * @generated
    */
    public void setProfileBuilder(ProfileBuilder profileBuilder) {
        this.profileBuilder = profileBuilder;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
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
