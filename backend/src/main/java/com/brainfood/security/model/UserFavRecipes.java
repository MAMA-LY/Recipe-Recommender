package com.brainfood.security.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ToString
@Entity
@Table(name = "\"UserFavRecipes\"")
@Getter
@Setter
public class UserFavRecipes implements Serializable {

    @EmbeddedId
    private UserFavRecipesCK compositeKey;


}
