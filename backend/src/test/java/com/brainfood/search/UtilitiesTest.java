package com.brainfood.search;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.brainfood.backend.db_entities.Recipe;
import com.brainfood.models.ShortRecipeModel;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UtilitiesTest {
    List<Recipe> Data;

    @BeforeEach
    void clearList() {
        Data = new ArrayList<>();
    }

    @Test
    void nullInputEliminateDuplicates() {
        assertThatCode(() -> Utilities.eliminateDuplicates(null)).doesNotThrowAnyException();
    }

    @Test
    void nullInputCastToArray() {
        assertThatCode(() -> Utilities.castToArray(null)).doesNotThrowAnyException();
    }

    @Test
    void emptyListEliminateDuplicates() {
        var result = Utilities.eliminateDuplicates(Data);
        assertArrayEquals(new ShortRecipeModel[0], result);
    }

    @Test
    void emptyListCastToArray() {
        var result = Utilities.castToArray(Data);
        assertArrayEquals(new ShortRecipeModel[0], result);
    }

    @Test
    @Tag("No Duplicates Check")
    void checkEliminateDuplicates1() {
        Data.add(Recipe.builder().id("123").name("first").photo("11111").build());
        Data.add(Recipe.builder().id("111").name("third").photo("11222111").build());
        Data.add(Recipe.builder().id("222").name("fourth").photo("11133111").build());

        ShortRecipeModel[] expected = new ShortRecipeModel[3];
        expected[0] = ShortRecipeModel.builder().id("123").name("first").image("11111").build();
        expected[1] = ShortRecipeModel.builder().id("111").name("third").image("11222111").build();
        expected[2] = ShortRecipeModel.builder().id("222").name("fourth").image("11133111").build();

        ShortRecipeModel[] result = Utilities.eliminateDuplicates(Data);
        this.assertShortRecipeModelArrays(result, expected);
    }

    @Test
    @Tag("Duplicates Check")
    void checkEliminateDuplicates2() {
        Data.add(Recipe.builder().id("123").name("first").photo("11111").build());
        Data.add(Recipe.builder().id("111").name("third").photo("11222111").build());
        Data.add(Recipe.builder().id("111").name("third").photo("11222111").build());
        Data.add(Recipe.builder().id("222").name("fourth").photo("11133111").build());
        Data.add(Recipe.builder().id("222").name("fourth").photo("11133111").build());

        ShortRecipeModel[] expected = new ShortRecipeModel[3];
        expected[0] = ShortRecipeModel.builder().id("123").name("first").image("11111").build();
        expected[1] = ShortRecipeModel.builder().id("111").name("third").image("11222111").build();
        expected[2] = ShortRecipeModel.builder().id("222").name("fourth").image("11133111").build();

        ShortRecipeModel[] result = Utilities.eliminateDuplicates(Data);
        this.assertShortRecipeModelArrays(result, expected);
    }

    @Test
    @Tag("One null image exist")
    void checkCastToArray() {
        Data.add(Recipe.builder().id("123").name("first").photo("11111").build());
        Data.add(Recipe.builder().id("321").name("second").build());
        Data.add(Recipe.builder().id("111").name("third").photo("11222111").build());
        Data.add(Recipe.builder().id("222").name("fourth").photo("11133111").build());

        ShortRecipeModel[] expected = new ShortRecipeModel[3];
        expected[0] = ShortRecipeModel.builder().id("123").name("first").image("11111").build();
        expected[1] = ShortRecipeModel.builder().id("111").name("third").image("11222111").build();
        expected[2] = ShortRecipeModel.builder().id("222").name("fourth").image("11133111").build();

        ShortRecipeModel[] result = Utilities.castToArray(Data);
        this.assertShortRecipeModelArrays(result, expected);
    }

    private void assertShortRecipeModelArrays(ShortRecipeModel[] result, ShortRecipeModel[] expected) {
        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i].id, result[i].id);
            assertEquals(expected[i].name, result[i].name);
            assertEquals(expected[i].image, result[i].image);
        }
    }
}