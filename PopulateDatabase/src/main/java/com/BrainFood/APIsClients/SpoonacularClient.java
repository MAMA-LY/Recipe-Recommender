package com.BrainFood.APIsClients;

import com.spoonacular.RecipesApi;
import com.spoonacular.client.*;
import com.spoonacular.client.auth.ApiKeyAuth;
import com.spoonacular.client.model.GetRandomRecipes200Response;

public class SpoonacularClient {
    private final RecipesApi recipesApi;
    public SpoonacularClient(){
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.spoonacular.com");
        ApiKeyAuth apiKeyScheme = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyScheme");
        apiKeyScheme.setApiKey(System.getenv("SpoonacularApiKey"));
        recipesApi = new RecipesApi(defaultClient);

    }
    public GetRandomRecipes200Response getRandomRecipes(int number, String tag) {

        Boolean limitLicense = true;
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


}
