package com.brainfood.backend.db_entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "\"RecipeTags\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeTags {
    @EmbeddedId
    private RecipeTagsCK compositeKey;
}