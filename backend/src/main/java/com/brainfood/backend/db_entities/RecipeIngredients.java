
package com.brainfood.backend.db_entities;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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