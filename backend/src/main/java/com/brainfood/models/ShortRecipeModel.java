package com.brainfood.models;

import com.brainfood.backend.db_entities.Recipe;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortRecipeModel {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    @JsonAlias("annotation")
    String name;

    @JsonProperty("tag")
    String tag;

    @JsonProperty("image")
    String image;

    public ShortRecipeModel(Recipe recipe) {
        this.id = recipe.id;
        this.name = recipe.name;
        this.image = recipe.photo;
    }
}
