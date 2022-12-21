package com.brainfood.backend.db_entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class RecipeIngredientsCK implements Serializable {
    @Column(name = "recipeid")
    public String recipeID;

    @Column(name = "ingredientid")
    public String ingredientID;
}