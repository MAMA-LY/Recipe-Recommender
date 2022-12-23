<<<<<<< HEAD:backend/src/main/java/com/brainfood/search/DBEntities/Recipe.java
package com.brainfood.search.DBEntities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Recipe\"")
@Getter @Setter
=======
package com.brainfood.backend.db_entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "\"Recipe\"")
@Getter
@Setter
>>>>>>> main:backend/src/main/java/com/brainfood/backend/db_entities/RecipeDB.java
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDB implements Serializable {

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
}