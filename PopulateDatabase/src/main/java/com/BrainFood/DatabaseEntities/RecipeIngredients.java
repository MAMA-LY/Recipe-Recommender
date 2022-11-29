package com.BrainFood.DatabaseEntities;

import lombok.Builder;
import jakarta.persistence.Entity;

@Entity
@Builder
public class RecipeIngredients {
    private String recipeID;

    private String ingredientID;
}
