package com.BrainFood.PopulateDatabase;

import com.BrainFood.Collectors.CollectorFitters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class UnitTesting {

    @Test
    public void testGetTotalHappyScenario(){
        JSONObject firstJson = new JSONObject();
        firstJson.put("GRAMS",new BigDecimal(5));
        JSONObject secondJson = new JSONObject();
        secondJson.put("GRAMS",new BigDecimal(12));
        JSONObject thirdJson = new JSONObject();
        thirdJson.put("GRAMS",new BigDecimal(32));
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(firstJson);
        jsonArray.put(secondJson);
        jsonArray.put(thirdJson);
        CollectorFitters collectorFitters =new CollectorFitters();
        int expectedReturn = 49;
        Assertions.assertEquals(expectedReturn, collectorFitters.getTotalOf(jsonArray, "GRAMS"));

    }
    @Test
    public void testGetTotalWorstScenario(){
        JSONObject firstJson = new JSONObject();
        firstJson.put("dollars",new BigDecimal(100));
        JSONObject secondJson = new JSONObject();
        secondJson.put("Dollsrs",new BigDecimal(12));
        JSONObject thirdJson = new JSONObject();
        thirdJson.put("doLLags",new BigDecimal(32));
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(firstJson);
        jsonArray.put(secondJson);
        jsonArray.put(thirdJson);
        CollectorFitters collectorFitters = new CollectorFitters();
        JSONException exception = Assertions.assertThrows(JSONException.class, () -> {
            var res = collectorFitters.getTotalOf(jsonArray, "dollars");
        });
        String expectedMessage = "Non-Compatible Keys";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(actualMessage, expectedMessage);

    }
    @Test
    public void testNormalMerger(){
        List<String> a = Arrays.asList("2", "5", "9");
        List<String> b = Arrays.asList("20", "6", "8");
        List<String> c = Arrays.asList("1", "3", "7");
        List<String> d = Arrays.asList("10", "2");
        Assertions.assertEquals(Arrays.asList("2", "5", "9", "20", "6", "8", "1", "3", "7", "10", "2"), Stream
                .of(a, b, c, d)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .toList());
    }
    @Test
    public void testNullMerger(){
        List<String> a = null;
        List<String> b = null;
        List<String> c = Arrays.asList("1", "3", "7");
        List<String> d = null;
        Assertions.assertEquals(Arrays.asList("1", "3", "7"), Stream
                .of(a, b, c, d)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .toList());
    }
}