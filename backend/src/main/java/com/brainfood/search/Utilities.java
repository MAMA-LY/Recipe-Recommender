package com.brainfood.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.brainfood.backend.db_entities.Recipe;
import com.brainfood.models.ShortRecipeModel;

public class Utilities {
    private static final int requestSize = 100;

    /**
     * eliminate duplicates and null-image objects in a list of recipes and
     * transform it to array
     *
     * @param list the desired list to be handled
     * @return the inserted list after eliminating duplicates and null-image recipes
     *         and transform it to array of ShortRecipeModel
     */
    public static ShortRecipeModel[] eliminateDuplicates(List<Recipe> list) {
        if (list == null)
            return new ShortRecipeModel[0];

        Set<String> ids = new TreeSet<>();
        List<ShortRecipeModel> unique = new ArrayList<>();
        for (Recipe recipe : list) {
            if (!ids.contains(recipe.id) && recipe.photo != null) {
                unique.add(new ShortRecipeModel(recipe));
                ids.add(recipe.id);
                if (ids.size() == requestSize)
                    break;
            }
        }
        return unique.toArray(new ShortRecipeModel[unique.size()]);
    }

    /**
     * transform a list of recipes to array of ShortRecipeModel and remove
     * null-image ones
     *
     * @param result the desired list to be handled
     * @return the inserted list after removing null-image recipes and transform it
     *         to array of ShortRecipeModel
     */
    public static ShortRecipeModel[] castToArray(List<Recipe> result) {
        if (result == null)
            return new ShortRecipeModel[0];

        List<ShortRecipeModel> toReturn = new ArrayList<>();
        for (Recipe recipe : result) {
            if (recipe.photo != null)
                toReturn.add(new ShortRecipeModel(recipe));
        }
        return toReturn.toArray(new ShortRecipeModel[toReturn.size()]);
    }
}
