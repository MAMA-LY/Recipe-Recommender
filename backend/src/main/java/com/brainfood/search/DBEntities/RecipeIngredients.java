package com.brainfood.search.DBEntities;

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