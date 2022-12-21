package com.brainfood.search;

import com.brainfood.search.DBEntities.Recipe;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * a class to parse the requested objects from spoonacular api and hold the data that is sent to the front
 **/
@Builder
@AllArgsConstructor
public class ShortRecipe {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    @JsonAlias("annotation")
    String name;

    @JsonProperty(value = "tag", access = JsonProperty.Access.WRITE_ONLY)
    String tag;

    @JsonProperty("image")
    String image;

    public ShortRecipe(Recipe recipe) {
        this.id = recipe.id;
        this.name = recipe.name;
        this.image = recipe.photo;
    }

    public ShortRecipe() {
    }
}
