package com.brainfood.backend;

import java.util.List;

import com.brainfood.backend.models.Recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRecommender {

    private Model model;

    // Operations

    public List<Recipe> recommend() {
        //
        return null;
    }

}
