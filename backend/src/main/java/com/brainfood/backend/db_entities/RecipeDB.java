package com.brainfood.backend.db_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "\"Recipe\"")
@Getter
@Setter
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