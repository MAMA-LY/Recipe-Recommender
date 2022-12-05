package com.brainfood.search.DBEntities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Ingredient\"")
@Data
public class Ingredient implements Serializable {
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
