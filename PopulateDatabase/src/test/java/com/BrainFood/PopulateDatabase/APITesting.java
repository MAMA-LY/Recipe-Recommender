package com.BrainFood.PopulateDatabase;

import com.BrainFood.APIsClients.CalorieNinjasClient;
import com.BrainFood.APIsClients.SpoonacularClient;
import com.spoonacular.client.model.GetRandomRecipes200Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class APITesting {
    @Test
    public void testSpoonacularGetRandomEasyTest(){
        SpoonacularClient spoonacularClient = new SpoonacularClient();
        GetRandomRecipes200Response response = spoonacularClient.getRandomRecipes(10,"gluten free");
        Assertions.assertEquals(10, response.getRecipes().size());
    }
    @Test
    public void testCalorieNinjasTestCalories(){
        JSONObject response = CalorieNinjasClient.getNutrition("tomato");
        Assertions.assertEquals(18, ((BigDecimal)((JSONObject)((JSONArray)response.get("items")).get(0)).get("calories")).intValue());
    }
    @Test
    public void testCalorieNinjasTestFats(){
        JSONObject response = CalorieNinjasClient.getNutrition("chicken");
        Assertions.assertEquals(12, ((BigDecimal)((JSONObject)((JSONArray)response.get("items")).get(0)).get("fat_total_g")).intValue());
    }
    @Test
    public void testCalorieNinjasTestCarbs(){
        JSONObject response = CalorieNinjasClient.getNutrition("burger");
        Assertions.assertEquals(18, ((BigDecimal)((JSONObject)((JSONArray)response.get("items")).get(0)).get("carbohydrates_total_g")).intValue());
    }
    @Test
    public void testCalorieNinjasTestProteins(){
        JSONObject response = CalorieNinjasClient.getNutrition("burger");
        Assertions.assertEquals(15, ((BigDecimal)((JSONObject)((JSONArray)response.get("items")).get(0)).get("protein_g")).intValue());
    }
}
