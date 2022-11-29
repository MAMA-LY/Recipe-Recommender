package com.BrainFood.DatabaseObjectsPackage;
import java.awt.*;
import java.util.List;

/**
 * @generated
 */
public class Recipe {

    /**
     * @generated
     */
    private String ID;

    /**
     * @generated
     */
    private List<String> Tags;

    /**
     * @generated
     */
    private String Cuisine ;

    /**
     * @generated
     */
    private String name;

    /**
     * @generated
     */
    private List<Ingredient> ingredients;

    /**
     * @generated
     */
    private Image photo;

    /**
     * @generated
     */
    private Nutritions nutritions;


    /**
     * @generated
     */
    private RecipeBuilder recipeBuilder;



    /**
     * @generated
     */
    public String getID() {
        return this.ID;
    }

    /**
     * @generated
     */
    public void setID(String ID) {
        this.ID = ID;
    }


    /**
     * @generated
     */
    public List<String> getTags() {
        return this.Tags;
    }

    /**
     * @generated
     */
    public void setTags(List<String> Tags) {
        this.Tags = Tags;
    }


    /**
     * @generated
     */
    public String getCuisine () {
        return this.Cuisine ;
    }

    /**
     * @generated
     */
    public void setCuisine(String Cuisine ) {
        this.Cuisine  = Cuisine ;
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
    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    /**
     * @generated
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    /**
     * @generated
     */
    public Image getPhoto() {
        return this.photo;
    }

    /**
     * @generated
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }


    /**
     * @generated
     */
    public Nutritions getNutritions() {
        return this.nutritions;
    }

    /**
     * @generated
     */
    public void setNutritions(Nutritions nutritions) {
        this.nutritions = nutritions;
    }



    /**
     * @generated
     */
    public RecipeBuilder getRecipeBuilder() {
        return this.recipeBuilder;
    }

    /**
     * @generated
     */
    public void setRecipeBuilder(RecipeBuilder recipeBuilder) {
        this.recipeBuilder = recipeBuilder;
    }



}