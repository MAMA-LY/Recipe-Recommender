package com.BrainFood.DatabaseEntities;

import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;

@Entity
@Table(name = "RecipeTags")
@Builder
public class RecipeTags {
    @EmbeddedId
    private RecipeTagsCK compositeKey;
}
@Embeddable
@Builder
class RecipeTagsCK implements Serializable {
    @Column(name = "recipeID", nullable = false)
    private String recipeID;

    @Column(name = "tag", nullable = false)
    private String tag;
}