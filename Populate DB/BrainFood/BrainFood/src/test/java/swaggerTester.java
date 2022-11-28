import MAMALY.Swaggers.SpoonacularSwagger;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class swaggerTester {
    @Test
    public void RecipeIngredientsTest() throws IOException, InterruptedException, JSONException {
        JSONArray ingredients = SpoonacularSwagger.getIngredientsByID(1003464);
        int expectedIngredientsNumber = 11;
        Assertions.assertEquals(expectedIngredientsNumber, ingredients.length());

    }
}
