package com.brainfood.search;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ComponentScan
@RestController
@RequestMapping("search")
public class SearchController {

    @GetMapping("/sentence")
    public String searchSentence(@RequestParam String sentence) throws IOException, InterruptedException, JSONException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spoonacular.com/food/detect"))
                .header("x-api-key" , "2e10b27e8eb44dc89bf4f46ff05552ed")
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(sentence))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(sentence);
        System.out.println(response.body());
        return response.body();
    }
}