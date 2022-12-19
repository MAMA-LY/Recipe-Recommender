package com.brainfood.search;

import com.brainfood.search.DBEntities.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Utilities {
    private static final int requestSize = 100;

    /**
     * eliminate duplicates and null-image objects in a list of recipes and transform it to array
     *
     * @param list the desired list to be handled
     * @return the inserted list after eliminating duplicates and null-image recipes and transform it to array of ShortRecipe
     */
    public static ShortRecipe[] eliminateDuplicates(List<Recipe> list) {
        if (list == null)
            return new ShortRecipe[0];

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

    /**
     * transform a list of recipes to array of ShortRecipe and remove null-image ones
     *
     * @param result the desired list to be handled
     * @return the inserted list after removing null-image recipes and transform it to array of ShortRecipe
     */
    public static ShortRecipe[] castToArray(List<Recipe> result) {
        if (result == null)
            return new ShortRecipe[0];

        List<ShortRecipe> toReturn = new ArrayList<>();
        for (Recipe recipe : result) {
            if (recipe.photo != null)
                toReturn.add(new ShortRecipe(recipe));
        }
        return toReturn.toArray(new ShortRecipe[toReturn.size()]);
    }
}
