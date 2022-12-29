package com.brainfood.backend.db_entities;

import java.io.Serializable;

import org.yaml.snakeyaml.util.UriEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFavRecipesCK implements Serializable {
    @Column(name = "userid")
    public String userID;;

    @Column(name = "recipeid")
    public String recipeID;

   

}