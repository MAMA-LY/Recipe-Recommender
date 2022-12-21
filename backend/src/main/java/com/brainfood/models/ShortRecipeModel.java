package com.brainfood.models;

import com.brainfood.backend.db_entities.Recipe;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * a class to parse the requested objects from spoonacular api and hold the data
 * that is sent to the front
 **/
@Builder
@AllArgsConstructor
public class ShortRecipeModel {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    @JsonAlias("annotation")
    public String name;

    @JsonProperty(value = "tag", access = JsonProperty.Access.WRITE_ONLY)
    public String tag;

    @JsonProperty("image")
    public String image;

    public ShortRecipeModel(Recipe recipe) {
        this.id = recipe.id;
        this.name = recipe.name;
        this.image = recipe.photo;
    }

    public ShortRecipeModel() {
    }
}
