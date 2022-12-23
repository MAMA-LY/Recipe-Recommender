package com.brainfood.backend.db_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "\"Ingredient\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDB implements Serializable {
    @Id
    @Column(name = "id")
    public String id;

    @Column(name = "name")
    public String name;

    @Column(name = "icon")
    public String icon;

    @Column(name = "calories")
    public int calories;

    @Column(name = "amount")
    public String amount;

    @Column(name = "proteins")
    public int proteins;

    @Column(name = "carbs")
    public int carbs;

    @Column(name = "fats")
    public int fats;

}
