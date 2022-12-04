package com.brainfood.search.DBEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

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
}