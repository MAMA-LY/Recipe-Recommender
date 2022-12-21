package com.brainfood.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.brainfood.models.ShortRecipe;

@Service
public class DishIngredientClassifier {
    private List<ShortRecipe> dish = new ArrayList<>();
    private List<ShortRecipe> ingredient = new ArrayList<>();

    void classify(List<ShortRecipe> food) {
        dish = new ArrayList<>();
        ingredient = new ArrayList<>();
        if (food == null)
            return;
        for (ShortRecipe recipe : food) {
            if (Objects.equals(recipe.tag, "dish"))
                dish.add(recipe);
            else
                ingredient.add(recipe);
        }
    }

    List<ShortRecipe> getDish() {
        return dish;
    }

    List<ShortRecipe> getIngredient() {
        return ingredient;
    }
}
