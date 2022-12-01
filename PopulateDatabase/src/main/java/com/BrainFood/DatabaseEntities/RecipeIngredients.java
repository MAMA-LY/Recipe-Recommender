package com.BrainFood.DatabaseEntities;

import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;

@Entity
@Table(name = "RecipeIngredients")
@Builder
public class RecipeIngredients {
    @EmbeddedId
    private RecipeIngredientsCK compositeKey;

}
@Embeddable
@Builder
class RecipeIngredientsCK implements Serializable {
    @Column(name = "recipeID", nullable = false)
    private String recipeID;

    @Column(name = "ingredientID", nullable = false)
    private String ingredientID;
}