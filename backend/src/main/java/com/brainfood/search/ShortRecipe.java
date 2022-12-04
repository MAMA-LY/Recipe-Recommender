package com.brainfood.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortRecipe {
    @JsonProperty("id")
    String id ;

    @JsonProperty("annotation")
    String name;

    @JsonProperty("tag")
    String tag;

    @JsonProperty("image")
    String image;
}
