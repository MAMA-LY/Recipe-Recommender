package com.brainfood.search;

import com.brainfood.search.DBEntities.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Utilities {
    private static int requestSize = 100 ;

    public static ShortRecipe[] eliminateDuplicates(List<Recipe> list) {
        Set<String> ids = new TreeSet<>();
        List<ShortRecipe> unique = new ArrayList<>();
        for (Recipe recipe : list) {
            if (!ids.contains(recipe.id) && recipe.photo != null) {
                unique.add(new ShortRecipe(recipe));
                ids.add(recipe.id);
                if (ids.size() == requestSize)
                    break;
            }
        }
        return unique.toArray(new ShortRecipe[unique.size()]);
    }

    public static ShortRecipe[] castToArray(List<Recipe> result) {
        List<ShortRecipe> toReturn = new ArrayList<>();
        for (Recipe recipe : result) {
            if (recipe.photo != null)
                toReturn.add(new ShortRecipe(recipe));
        }
        return toReturn.toArray(new ShortRecipe[toReturn.size()]);
    }
}
