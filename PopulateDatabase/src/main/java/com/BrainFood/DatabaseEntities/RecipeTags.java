package com.BrainFood.DatabaseEntities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "\"RecipeTags\"")
@Data @Builder
public class RecipeTags implements Serializable{
    @EmbeddedId
    private RecipeTagsCK compositeKey;
}
