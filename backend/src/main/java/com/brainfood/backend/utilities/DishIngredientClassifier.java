package com.brainfood.backend.utilities;

import com.brainfood.backend.models.ShortRecipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DishIngredientClassifier {
    private List<ShortRecipe> dish = new ArrayList<>();
    private List<ShortRecipe> ingredient = new ArrayList<>();

    public void classify(List<ShortRecipe> food) {
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

    public List<ShortRecipe> getDish() {
        return dish;
    }

    public List<ShortRecipe> getIngredient() {
        return ingredient;
    }
}
