package com.brainfood.search.DBEntities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class RecipeIngredientsCK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "recipeID")
    public Recipe recipeID;

    @ManyToOne
    @JoinColumn(name = "ingredientID")
    public Ingredient ingredientID;
}
