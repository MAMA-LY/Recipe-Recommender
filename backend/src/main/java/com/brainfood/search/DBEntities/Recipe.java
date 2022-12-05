package com.brainfood.search.DBEntities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"Recipe\"")
@Data
public class Recipe implements Serializable {

    @Id
    @Column(name = "id")
    public String id;

    @Column(name = "cuisine")
    public String cuisine ;

    @Column(name = "name")
    public String name;

    @Column(name = "calories")
    public int calories;

    @Column(name = "proteins")
    public int proteins;

    @Column(name = "fats")
    public int fats;

    @Column(name = "photo")
    public String photo;

    @OneToMany(mappedBy = "compositeKey.recipeID" , cascade = CascadeType.ALL , orphanRemoval = true)
    public Set<RecipeIngredients> recipeIngredients = new HashSet<>() ;
}