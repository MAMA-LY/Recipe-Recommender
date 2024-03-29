package com.brainfood.backend.db_entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

@Component
@ToString
@Entity
@Table(name = "\"User\"")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private String ID;

    @Column(name = "photo")
    private String photo;

    @Column(name = "username")
    private String username;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "dailycalories")
    private int dailyCalories;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "gender")
    private String gender;

}
