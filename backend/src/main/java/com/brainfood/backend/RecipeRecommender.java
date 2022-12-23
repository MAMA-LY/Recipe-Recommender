package com.brainfood.backend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

<<<<<<< HEAD
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RecipeRecommender {

    private Model model;

    //                          Operations                                  

=======
import com.brainfood.models.Recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRecommender {

    private Model model;

    // Operations

>>>>>>> main
    public List<Recipe> recommend() {
        //
        return null;
    }

}
