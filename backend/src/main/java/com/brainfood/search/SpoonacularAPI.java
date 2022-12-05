package com.brainfood.search;

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
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SpoonacularAPI {

    public JSONObject foodText(String text) throws JSONException, IOException, InterruptedException {
        var params = new HashMap<String, String>();
        params.put("text", text);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spoonacular.com/food/detect"))
                .header("x-api-key", "2e10b27e8eb44dc89bf4f46ff05552ed")
                .POST(getParamsUrlEncoded(params))
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return new JSONObject(response.body());
    }

    private HttpRequest.BodyPublisher getParamsUrlEncoded(Map<String, String> parameters) {
        String urlEncoded = parameters.entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));
        return HttpRequest.BodyPublishers.ofString(urlEncoded);
    }
}


