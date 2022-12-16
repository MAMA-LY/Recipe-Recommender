package com.brainfood.backend.db_entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "\"RecipeIngredients\"")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredients implements Serializable{
    @EmbeddedId
    private RecipeIngredientsCK compositeKey;
}