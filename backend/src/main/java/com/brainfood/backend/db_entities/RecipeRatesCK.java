package com.brainfood.backend.db_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRatesCK implements Serializable {
    @Column(name = "recipe_id")
    public String recipeID;

    @Column(name = "user_id")
    public String userID;
}
