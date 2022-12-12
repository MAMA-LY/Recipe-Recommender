package com.brainfood.backend;

import lombok.*;

import java.util.List;
import java.awt.Image;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Recipe {

    private String ID;

    private List<String> Tags;

    private String Cuisine ;

    private String name;

    private List<Ingredient> ingredients;

    private Image photo;

    private Nutritions nutritions;

    private RecipeBuilder recipeBuilder;

    
    
    
}
