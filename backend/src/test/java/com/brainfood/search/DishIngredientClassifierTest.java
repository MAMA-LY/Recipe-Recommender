package com.brainfood.search;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.brainfood.models.ShortRecipeModel;;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DishIngredientClassifierTest {
    List<ShortRecipeModel> food;
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
        List<ShortRecipeModel> result = new ArrayList<>();
        assertIterableEquals(result, dishIngredientClassifier.getDish());
        assertIterableEquals(result, dishIngredientClassifier.getIngredient());
    }

    @Test
    void classifyEmptyList() {
        List<ShortRecipeModel> result = new ArrayList<>();
        dishIngredientClassifier.classify(food);
        assertIterableEquals(result, dishIngredientClassifier.getDish());
        assertIterableEquals(result, dishIngredientClassifier.getIngredient());
    }

    @Test
    void classifyAllDishes() {
        food.add(ShortRecipeModel.builder().id("111").tag("dish").build());
        food.add(ShortRecipeModel.builder().id("114").tag("dish").build());
        food.add(ShortRecipeModel.builder().id("222").tag("dish").build());
        food.add(ShortRecipeModel.builder().id("444").tag("dish").build());
        dishIngredientClassifier.classify(food);

        List<ShortRecipeModel> dishResult = new ArrayList<>();
        List<ShortRecipeModel> IngredientResult = new ArrayList<>();

        dishResult.add(ShortRecipeModel.builder().id("111").tag("dish").build());
        dishResult.add(ShortRecipeModel.builder().id("114").tag("dish").build());
        dishResult.add(ShortRecipeModel.builder().id("222").tag("dish").build());
        dishResult.add(ShortRecipeModel.builder().id("444").tag("dish").build());

        assertShortRecipeModelLists(dishResult, dishIngredientClassifier.getDish());
        assertShortRecipeModelLists(IngredientResult, dishIngredientClassifier.getIngredient());
    }

    @Test
    void classifyAllIngredients() {
        food.add(ShortRecipeModel.builder().id("111").tag("Ingredient").build());
        food.add(ShortRecipeModel.builder().id("114").tag("Ingredient").build());
        food.add(ShortRecipeModel.builder().id("222").tag("Ingredient").build());
        food.add(ShortRecipeModel.builder().id("444").tag("Ingredient").build());
        dishIngredientClassifier.classify(food);

        List<ShortRecipeModel> dishResult = new ArrayList<>();
        List<ShortRecipeModel> IngredientResult = new ArrayList<>();

        IngredientResult.add(ShortRecipeModel.builder().id("111").tag("Ingredient").build());
        IngredientResult.add(ShortRecipeModel.builder().id("114").tag("Ingredient").build());
        IngredientResult.add(ShortRecipeModel.builder().id("222").tag("Ingredient").build());
        IngredientResult.add(ShortRecipeModel.builder().id("444").tag("Ingredient").build());

        assertShortRecipeModelLists(dishResult, dishIngredientClassifier.getDish());
        assertShortRecipeModelLists(IngredientResult, dishIngredientClassifier.getIngredient());
    }

    @Test
    void classifyMixing() {
        food.add(ShortRecipeModel.builder().id("111").tag("Ingredient").build());
        food.add(ShortRecipeModel.builder().id("114").tag("Ingredient").build());
        food.add(ShortRecipeModel.builder().id("222").tag("Ingredient").build());
        food.add(ShortRecipeModel.builder().id("444").tag("Ingredient").build());

        food.add(ShortRecipeModel.builder().id("11556").tag("dish").build());
        food.add(ShortRecipeModel.builder().id("11244").tag("dish").build());
        food.add(ShortRecipeModel.builder().id("22442").tag("dish").build());
        food.add(ShortRecipeModel.builder().id("41244").tag("dish").build());

        dishIngredientClassifier.classify(food);

        List<ShortRecipeModel> dishResult = new ArrayList<>();
        List<ShortRecipeModel> IngredientResult = new ArrayList<>();

        dishResult.add(ShortRecipeModel.builder().id("11556").tag("dish").build());
        dishResult.add(ShortRecipeModel.builder().id("11244").tag("dish").build());
        dishResult.add(ShortRecipeModel.builder().id("22442").tag("dish").build());
        dishResult.add(ShortRecipeModel.builder().id("41244").tag("dish").build());

        IngredientResult.add(ShortRecipeModel.builder().id("111").tag("Ingredient").build());
        IngredientResult.add(ShortRecipeModel.builder().id("114").tag("Ingredient").build());
        IngredientResult.add(ShortRecipeModel.builder().id("222").tag("Ingredient").build());
        IngredientResult.add(ShortRecipeModel.builder().id("444").tag("Ingredient").build());

        assertShortRecipeModelLists(dishResult, dishIngredientClassifier.getDish());
        assertShortRecipeModelLists(IngredientResult, dishIngredientClassifier.getIngredient());
    }

    private void assertShortRecipeModelLists(List<ShortRecipeModel> expected, List<ShortRecipeModel> result) {
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expected.get(i).id, result.get(i).id);
            assertEquals(expected.get(i).name, result.get(i).name);
            assertEquals(expected.get(i).image, result.get(i).image);
            assertEquals(expected.get(i).tag, result.get(i).tag);
        }
    }

}