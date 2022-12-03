package com.BrainFood.DatabaseEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeTagsCK implements Serializable {
    @Column(name = "recipeID", nullable = false)
    private String recipeID;

    @Column(name = "tag", nullable = false)
    private String tag;
}
