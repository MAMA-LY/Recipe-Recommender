package com.brainfood.models;

import com.brainfood.backend.db_entities.RecipeDB;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * a class to parse the requested objects from spoonacular api and hold the data
 * that is sent to the front
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortRecipe {

    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    @JsonAlias("annotation")
    public String name;

    @JsonProperty(value = "tag", access = JsonProperty.Access.WRITE_ONLY)
    public String tag;

    @JsonProperty("image")
    public String image;

    public ShortRecipe(RecipeDB recipeDB) {
        this.id = recipeDB.id;
        this.name = recipeDB.name;
        this.image = recipeDB.photo;
    }
}
