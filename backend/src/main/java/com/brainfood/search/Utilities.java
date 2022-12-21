package com.brainfood.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.models.ShortRecipe;

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
    public static ShortRecipe[] eliminateDuplicates(List<RecipeDB> list) {
        if (list == null)
            return new ShortRecipe[0];

        Set<String> ids = new TreeSet<>();
        List<ShortRecipe> unique = new ArrayList<>();
        for (RecipeDB recipeDB : list) {
            if (!ids.contains(recipeDB.id) && recipeDB.photo != null) {
                unique.add(new ShortRecipe(recipeDB));
                ids.add(recipeDB.id);
                if (ids.size() == requestSize)
                    break;
            }
        }
        return unique.toArray(new ShortRecipe[unique.size()]);
    }

    /**
     * transform a list of recipes to array of ShortRecipeModel and remove
     * null-image ones
     *
     * @param result the desired list to be handled
     * @return the inserted list after removing null-image recipes and transform it
     *         to array of ShortRecipeModel
     */
    public static ShortRecipe[] castToArray(List<RecipeDB> result) {
        if (result == null)
            return new ShortRecipe[0];

        List<ShortRecipe> toReturn = new ArrayList<>();
        for (RecipeDB recipeDB : result) {
            if (recipeDB.photo != null)
                toReturn.add(new ShortRecipe(recipeDB));
        }
        return toReturn.toArray(new ShortRecipe[toReturn.size()]);
    }
}
