package com.brainfood.search;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DishIngredientClassifier {
    private List<ShortRecipe> dish ;
    private List<ShortRecipe> ingredient ;

    void classify(List<ShortRecipe> food){
        dish = new ArrayList<>() ;
        ingredient = new ArrayList<>() ;
        for(ShortRecipe recipe : food){
            if(Objects.equals(recipe.tag, "dish"))
                dish.add(recipe);
            else
                ingredient.add(recipe);
        }
    }

    List<ShortRecipe> getDish(){
        return dish ;
    }

    List<ShortRecipe> getIngredient(){
        return ingredient ;
    }
}
