package MAMALY.Swaggers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SpoonacularSwagger {
    public static JSONObject getRandomRecipe(int number) throws IOException, InterruptedException {
         HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?&number="+ number))
                .header("X-RapidAPI-Key", "2179e35da2mshf75f9d6bd9fca69p169778jsn475f5672c929")
                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(response);
    }
    public static JSONArray getIngredientsByID(int ID) throws IOException, InterruptedException, JSONException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"+ ID +"/ingredientWidget.json"))
                .header("X-RapidAPI-Key", "2179e35da2mshf75f9d6bd9fca69p169778jsn475f5672c929")
                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response);
        System.out.println(jsonObject);

        return jsonObject.getJSONArray("ingredients");
    }

}
