
package com.brainfood.backend.db_entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "\"RecipeIngredients\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredients implements Serializable {
    @EmbeddedId
    private RecipeIngredientsCK compositeKey;
}