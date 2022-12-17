package com.brainfood.search.DBEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Recipe\"")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
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
}