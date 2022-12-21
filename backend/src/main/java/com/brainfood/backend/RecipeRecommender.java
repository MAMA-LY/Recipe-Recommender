package com.brainfood.backend;

import com.brainfood.models.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RecipeRecommender {

    private Model model;

    //                          Operations                                  

    public List<Recipe> recommend() {
        //
        return null;
    }
    
    
}
