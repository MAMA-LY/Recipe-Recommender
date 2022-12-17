package com.brainfood.backend.db_entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"Recipe\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe implements Serializable {

    @Id
    @Column(name = "id")
    public String id;

    @Column(name = "cuisine")
    public String cuisine;

    @Column(name = "name")
    public String name;

    @Column(name = "calories")
    public int calories;

    @Column(name = "proteins")
    public int proteins;

    @Column(name = "fats")
    public int fats;

    @Column(name = "carbs")
    public int carbs;

    @Column(name = "photo")
    public String photo;

    @OneToMany(mappedBy = "recipe")
    public List<RecipeIngredients> recipeIngredients;
}