package com.brainfood.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.brainfood.models.ShortRecipeModel;

@Service
public class DishIngredientClassifier {
    private List<ShortRecipeModel> dish = new ArrayList<>();
    private List<ShortRecipeModel> ingredient = new ArrayList<>();

    void classify(List<ShortRecipeModel> food) {
        dish = new ArrayList<>();
        ingredient = new ArrayList<>();
        if (food == null)
            return;
        for (ShortRecipeModel recipe : food) {
            if (Objects.equals(recipe.tag, "dish"))
                dish.add(recipe);
            else
                ingredient.add(recipe);
        }
    }

    List<ShortRecipeModel> getDish() {
        return dish;
    }

    List<ShortRecipeModel> getIngredient() {
        return ingredient;
    }
}
