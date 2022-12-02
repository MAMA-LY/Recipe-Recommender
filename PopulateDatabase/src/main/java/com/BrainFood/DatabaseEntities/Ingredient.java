package com.BrainFood.DatabaseEntities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

@Entity
@Table(name = "\"Ingredient\"")
@Data @Builder
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ID", nullable = false)
    private String ID;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "icon")
    private String icon;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "amount")
    private String amount;

    @Column(name = "proteins", nullable = false)
    private int proteins;

    @Column(name = "fats", nullable = false)
    private int fats;

    @Column(name = "carbs")
    private int carbs;







}