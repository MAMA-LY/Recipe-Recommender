package com.BrainFood.APIsClients;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CalorieNinjasClient {
    public static JSONObject getNutrition(String food) throws IOException, InterruptedException {
        try {
            food=food.replaceAll("[ ()]","%20"); //api use %20 for space
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://calorieninjas.p.rapidapi.com/v1/nutrition?query=" + food))
                    .header("X-RapidAPI-Key", "2179e35da2mshf75f9d6bd9fca69p169778jsn475f5672c929")
                    .header("X-RapidAPI-Host", "calorieninjas.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return new JSONObject(response.body());
        }
        catch (Exception e)
        {
            return new JSONObject();
        }
    }
}
