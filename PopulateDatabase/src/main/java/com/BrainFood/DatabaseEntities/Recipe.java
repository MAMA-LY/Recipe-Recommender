package com.BrainFood.DatabaseEntities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;


@Entity
@Table(name = "\"Recipe\"")
@Data @Builder

@AllArgsConstructor
@NoArgsConstructor
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ID", nullable = false)
    private String ID;

    @Column(name = "cuisine")
    private String cuisine ;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "proteins", nullable = false)
    private int proteins;

    @Column(name = "fats", nullable = false)
    private int fats;

    @Column(name = "carbs", nullable = false)
    private int carbs;

    @Column(name = "photo")
    private String photo;



}