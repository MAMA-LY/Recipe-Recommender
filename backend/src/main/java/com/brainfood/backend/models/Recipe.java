package com.brainfood.backend.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    private String ID;

    private List<String> tags;

    private String cuisine;

    private String name;

    private List<Ingredient> ingredients;

    private String image;

    private Nutrition nutrition;

}
