package com.brainfood.backend.db_entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "\"RecipeIngredients\"")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredients implements Serializable {

    @EmbeddedId
    private RecipeIngredientsCK compositeKey;

    @ManyToOne
    @MapsId("recipeid")
    @JoinColumn(name="recipeid")
    public Recipe recipe;

    @ManyToOne
    @MapsId("ingredientid")
    @JoinColumn(name = "ingredientid")
    public Ingredient ingredient;

}