package com.brainfood.backend.utilities;

import com.brainfood.backend.models.ShortRecipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * a class to handle the requests to Spoonacular API and get its response
 */
@Service
public class SpoonacularAPI {

    /**
     * method that takes a plain text as an input and send it to spoonacular api to
     * detect the food in it
     *
     * @param text the text which needed to detect food in
     * @return a list with the food that spoonacular detected and each element has a
     * tag that specifies it is a dish or an ingredient
     */
    public List<ShortRecipe> foodText(String text) throws JSONException, IOException, InterruptedException {
        var params = new HashMap<String, String>();
        params.put("text", text);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spoonacular.com/food/detect"))
                .header("x-api-key", "2e10b27e8eb44dc89bf4f46ff05552ed")
                .POST(getParamsUrlEncoded(params))
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONArray food = new JSONObject(response.body()).getJSONArray("annotations");
        List<ShortRecipe> ans = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; !food.isNull(i); i++)
            ans.add(mapper.readValue(food.getJSONObject(i).toString(), ShortRecipe.class));

        return ans;
    }

    private HttpRequest.BodyPublisher getParamsUrlEncoded(Map<String, String> parameters) {
        String urlEncoded = parameters.entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));
        return HttpRequest.BodyPublishers.ofString(urlEncoded);
    }
}
