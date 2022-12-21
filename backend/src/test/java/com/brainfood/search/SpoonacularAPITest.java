package com.brainfood.search;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.brainfood.models.ShortRecipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.configurationprocessor.json.JSONException;


class SpoonacularAPITest {
    SpoonacularAPI spoonacularAPI;

    @BeforeEach
    void clearList() {
        spoonacularAPI = new SpoonacularAPI();
    }

    @Test
    void emptyString() throws JSONException, IOException, InterruptedException {
        String food = "";
        var result = spoonacularAPI.foodText(food);
        assertIterableEquals(new ArrayList<>(), result);
    }

    @Test
    void onlyIngredientText() throws JSONException, IOException, InterruptedException {
        String food = "I love cheese and egg and garlic";
        var result = spoonacularAPI.foodText(food);
        Map<String, Boolean> expected = new HashMap<>();
        Map<String, String> expectedType = new HashMap<>();
        expected.put("cheese", false);
        expectedType.put("cheese", "ingredient");
        expected.put("egg", false);
        expectedType.put("egg", "ingredient");
        expected.put("garlic", false);
        expectedType.put("garlic", "ingredient");

        assertShortRecipeLists(expected, expectedType, result);
    }

    @Test
    void onlyDishesText() throws JSONException, IOException, InterruptedException {
        String food = "I love taco and pizza and icecream";
        var result = spoonacularAPI.foodText(food);
        Map<String, Boolean> expected = new HashMap<>();
        Map<String, String> expectedType = new HashMap<>();
        expected.put("icecream", false);
        expectedType.put("icecream", "dish");
        expected.put("pizza", false);
        expectedType.put("pizza", "dish");
        expected.put("taco", false);
        expectedType.put("taco", "dish");

        assertShortRecipeLists(expected, expectedType, result);
    }

    @Test
    void mixedTest() throws JSONException, IOException, InterruptedException {
        String food = "I love taco and pizza and icecream and egg and garlic";
        var result = spoonacularAPI.foodText(food);
        Map<String, Boolean> expected = new HashMap<>();
        Map<String, String> expectedType = new HashMap<>();
        expected.put("egg", false);
        expectedType.put("egg", "ingredient");
        expected.put("garlic", false);
        expectedType.put("garlic", "ingredient");
        expected.put("icecream", false);
        expectedType.put("icecream", "dish");
        expected.put("pizza", false);
        expectedType.put("pizza", "dish");
        expected.put("taco", false);
        expectedType.put("taco", "dish");

        assertShortRecipeLists(expected, expectedType, result);
    }

    private void assertShortRecipeLists(Map<String, Boolean> expected, Map<String, String> expectedType,
            List<ShortRecipe> result) {
        for (ShortRecipe ShortRecipe : result)
            if (!expected.containsKey(ShortRecipe.name))
                fail();
            else
                expected.put(ShortRecipe.name, true);
        for (String food : expected.keySet()) {
            if (!expected.get(food))
                fail();
        }

        for (ShortRecipe recipe : result) {
            if (!Objects.equals(recipe.tag, expectedType.get(recipe.name)))
                fail();
        }
    }
}