package com.brainfood.backend.db_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RecipeIngredientsCK implements Serializable {
    @Column(name = "recipeID")
    public String recipeID;

    @Column(name = "ingredientID")
    public String ingredientID;
}