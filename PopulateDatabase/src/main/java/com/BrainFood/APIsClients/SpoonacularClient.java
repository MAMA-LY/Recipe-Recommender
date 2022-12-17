package com.BrainFood.APIsClients;

import com.spoonacular.RecipesApi;
import com.spoonacular.client.*;
import com.spoonacular.client.auth.ApiKeyAuth;
import com.spoonacular.client.model.GetRandomRecipes200Response;
import com.spoonacular.client.model.GetRecipeNutritionWidgetByID200Response;

public class SpoonacularClient {
    private final RecipesApi recipesApi;
    public SpoonacularClient(){
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.spoonacular.com");
        ApiKeyAuth apiKeyScheme = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyScheme");
        apiKeyScheme.setApiKey("7f8f2feba63d4488843d574aaba79686");
        apiKeyScheme.setApiKeyPrefix(null);
        recipesApi = new RecipesApi(defaultClient);

    }
    public GetRandomRecipes200Response getRandomRecipes(int number, String tag) {

        Boolean limitLicense = false;
        try {
            return this.recipesApi.getRandomRecipes(limitLicense, tag, number);
        } catch (ApiException e) {
            System.err.println("Exception when calling RecipesApi#getRandomRecipes");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        return null;
    }
    public GetRecipeNutritionWidgetByID200Response getRecipeNutritionWidgetByID200Response(int id) {

        Boolean limitLicense = false;
        try {
            return this.recipesApi.getRecipeNutritionWidgetByID(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling RecipesApi#getRandomRecipes");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        return null;
    }


}
