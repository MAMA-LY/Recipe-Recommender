package com.brainfood.backend.db_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RecipeIngredientsCK implements Serializable {

    @Column(name="recipeid")
    public String recipeid;

    @Column(name="ingredientid")
    public String ingredientid;

}
