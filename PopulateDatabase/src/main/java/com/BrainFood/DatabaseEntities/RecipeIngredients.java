package com.BrainFood.DatabaseEntities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "\"RecipeIngredients\"")
@Data @Builder
public class RecipeIngredients implements Serializable{
    @EmbeddedId
    private RecipeIngredientsCK compositeKey;

}
