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
@Embeddable
@Data @Builder
class RecipeTagsCK implements Serializable {
    @Column(name = "recipeID", nullable = false)
    private String recipeID;

    @Column(name = "tag", nullable = false)
    private String tag;
}