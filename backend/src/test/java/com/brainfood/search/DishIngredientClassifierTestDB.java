package com.brainfood.search;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.brainfood.models.ShortRecipe;;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DishIngredientClassifierTestDB {
    List<ShortRecipe> food;
    DishIngredientClassifier dishIngredientClassifier;

    @BeforeEach
    void clearList() {
        food = new ArrayList<>();
        dishIngredientClassifier = new DishIngredientClassifier();
    }

    @Test
    void nullInputClassify() {
        assertThatCode(() -> dishIngredientClassifier.classify(null)).doesNotThrowAnyException();
    }

    @Test
    void getListsWithoutClassify() {
        List<ShortRecipe> result = new ArrayList<>();
        assertIterableEquals(result, dishIngredientClassifier.getDish());
        assertIterableEquals(result, dishIngredientClassifier.getIngredient());
    }

    @Test
    void classifyEmptyList() {
        List<ShortRecipe> result = new ArrayList<>();
        dishIngredientClassifier.classify(food);
        assertIterableEquals(result, dishIngredientClassifier.getDish());
        assertIterableEquals(result, dishIngredientClassifier.getIngredient());
    }

    @Test
    void classifyAllDishes() {
        food.add(ShortRecipe.builder().id("111").tag("dish").build());
        food.add(ShortRecipe.builder().id("114").tag("dish").build());
        food.add(ShortRecipe.builder().id("222").tag("dish").build());
        food.add(ShortRecipe.builder().id("444").tag("dish").build());
        dishIngredientClassifier.classify(food);

        List<ShortRecipe> dishResult = new ArrayList<>();
        List<ShortRecipe> IngredientResult = new ArrayList<>();

        dishResult.add(ShortRecipe.builder().id("111").tag("dish").build());
        dishResult.add(ShortRecipe.builder().id("114").tag("dish").build());
        dishResult.add(ShortRecipe.builder().id("222").tag("dish").build());
        dishResult.add(ShortRecipe.builder().id("444").tag("dish").build());

        assertShortRecipeModelLists(dishResult, dishIngredientClassifier.getDish());
        assertShortRecipeModelLists(IngredientResult, dishIngredientClassifier.getIngredient());
    }

    @Test
    void classifyAllIngredients() {
        food.add(ShortRecipe.builder().id("111").tag("Ingredient").build());
        food.add(ShortRecipe.builder().id("114").tag("Ingredient").build());
        food.add(ShortRecipe.builder().id("222").tag("Ingredient").build());
        food.add(ShortRecipe.builder().id("444").tag("Ingredient").build());
        dishIngredientClassifier.classify(food);

        List<ShortRecipe> dishResult = new ArrayList<>();
        List<ShortRecipe> IngredientResult = new ArrayList<>();

        IngredientResult.add(ShortRecipe.builder().id("111").tag("Ingredient").build());
        IngredientResult.add(ShortRecipe.builder().id("114").tag("Ingredient").build());
        IngredientResult.add(ShortRecipe.builder().id("222").tag("Ingredient").build());
        IngredientResult.add(ShortRecipe.builder().id("444").tag("Ingredient").build());

        assertShortRecipeModelLists(dishResult, dishIngredientClassifier.getDish());
        assertShortRecipeModelLists(IngredientResult, dishIngredientClassifier.getIngredient());
    }

    @Test
    void classifyMixing() {
        food.add(ShortRecipe.builder().id("111").tag("Ingredient").build());
        food.add(ShortRecipe.builder().id("114").tag("Ingredient").build());
        food.add(ShortRecipe.builder().id("222").tag("Ingredient").build());
        food.add(ShortRecipe.builder().id("444").tag("Ingredient").build());

        food.add(ShortRecipe.builder().id("11556").tag("dish").build());
        food.add(ShortRecipe.builder().id("11244").tag("dish").build());
        food.add(ShortRecipe.builder().id("22442").tag("dish").build());
        food.add(ShortRecipe.builder().id("41244").tag("dish").build());

        dishIngredientClassifier.classify(food);

        List<ShortRecipe> dishResult = new ArrayList<>();
        List<ShortRecipe> IngredientResult = new ArrayList<>();

        dishResult.add(ShortRecipe.builder().id("11556").tag("dish").build());
        dishResult.add(ShortRecipe.builder().id("11244").tag("dish").build());
        dishResult.add(ShortRecipe.builder().id("22442").tag("dish").build());
        dishResult.add(ShortRecipe.builder().id("41244").tag("dish").build());

        IngredientResult.add(ShortRecipe.builder().id("111").tag("Ingredient").build());
        IngredientResult.add(ShortRecipe.builder().id("114").tag("Ingredient").build());
        IngredientResult.add(ShortRecipe.builder().id("222").tag("Ingredient").build());
        IngredientResult.add(ShortRecipe.builder().id("444").tag("Ingredient").build());

        assertShortRecipeModelLists(dishResult, dishIngredientClassifier.getDish());
        assertShortRecipeModelLists(IngredientResult, dishIngredientClassifier.getIngredient());
    }

    private void assertShortRecipeModelLists(List<ShortRecipe> expected, List<ShortRecipe> result) {
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expected.get(i).id, result.get(i).id);
            assertEquals(expected.get(i).name, result.get(i).name);
            assertEquals(expected.get(i).image, result.get(i).image);
            assertEquals(expected.get(i).tag, result.get(i).tag);
        }
    }

}