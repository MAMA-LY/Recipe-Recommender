package com.brainfood.search.DBEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RecipeTagsCK implements Serializable {
    @Column(name = "recipeid")
    public String recipeID;

    @Column(name = "tag")
    public String tag;
}