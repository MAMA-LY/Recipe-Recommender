package com.brainfood.search.DBEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
public class RecipeIngredientsCK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "recipeID")
    public Recipe recipeID;

    @ManyToOne
    @JoinColumn(name = "ingredientID")
    public Ingredient ingredientID;
}
