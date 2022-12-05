package com.brainfood.search.DBEntities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "\"RecipeIngredients\"")
@Data
public class RecipeIngredients implements Serializable{
    @EmbeddedId
    private RecipeIngredientsCK compositeKey;
}