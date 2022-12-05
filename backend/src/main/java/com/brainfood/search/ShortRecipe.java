package com.brainfood.search;

import com.brainfood.search.DBEntities.Recipe;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortRecipe {

    @JsonProperty("id")
    String id;

    @JsonProperty("annotation")
    String name;

    @JsonProperty("tag")
    String tag;

    @JsonProperty("image")
    String image;

    public ShortRecipe(Recipe recipe) {
        this.id = recipe.id;
        this.name = recipe.name;
        this.image = recipe.photo;
    }

    public ShortRecipe(){
    }
}
