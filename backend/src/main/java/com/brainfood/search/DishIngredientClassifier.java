package com.brainfood.search;

import com.brainfood.models.ShortRecipeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DishIngredientClassifier {
    private List<ShortRecipeModel> dish ;
    private List<ShortRecipeModel> ingredient ;

    void classify(List<ShortRecipeModel> food){
        dish = new ArrayList<>() ;
        ingredient = new ArrayList<>() ;
        for(ShortRecipeModel recipe : food){
            if(Objects.equals(recipe.getTag(), "dish"))
                dish.add(recipe);
            else
                ingredient.add(recipe);
        }
    }

    List<ShortRecipeModel> getDish(){
        return dish ;
    }

    List<ShortRecipeModel> getIngredient(){
        return ingredient ;
    }
}
