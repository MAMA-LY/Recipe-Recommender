package com.brainfood.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipe {
    String id ;

    @JsonProperty("annotation")
    String Name;

    @JsonProperty("tag")
    String tag;

    @JsonProperty("image")
    String image;
}
