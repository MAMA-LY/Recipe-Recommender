package com.BrainFood.APIsClients;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LowCarbRecipesClient {
    public static JSONObject getRandomRecipe() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://low-carb-recipes.p.rapidapi.com/random"))
                .header("X-RapidAPI-Key", "2179e35da2mshf75f9d6bd9fca69p169778jsn475f5672c929")
                .header("X-RapidAPI-Host", "low-carb-recipes.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(response.body());
    }
}
