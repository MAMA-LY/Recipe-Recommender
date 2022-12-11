package com.brainfood.backend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Calendar {

    private List<Ingredient> ingredients;

    private List<Recipe> recipes;

    
}
