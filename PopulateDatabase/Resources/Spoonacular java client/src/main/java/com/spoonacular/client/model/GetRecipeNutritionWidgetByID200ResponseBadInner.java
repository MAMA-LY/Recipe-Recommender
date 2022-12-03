/*
 * spoonacular API
 * The spoonacular Nutrition, Recipe, and Food API allows you to access over thousands of recipes, thousands of ingredients, 800,000 food products, over 100,000 menu items, and restaurants. Our food ontology and semantic recipe search engine makes it possible to search for recipes using natural language queries, such as \"gluten free brownies without sugar\" or \"low fat vegan cupcakes.\" You can automatically calculate the nutritional information for any recipe, analyze recipe costs, visualize ingredient lists, find recipes for what's in your fridge, find recipes based on special diets, nutritional requirements, or favorite ingredients, classify recipes into types and cuisines, convert ingredient amounts, or even compute an entire meal plan. With our powerful API, you can create many kinds of food and especially nutrition apps.  Special diets/dietary requirements currently available include: vegan, vegetarian, pescetarian, gluten free, grain free, dairy free, high protein, whole 30, low sodium, low carb, Paleo, ketogenic, FODMAP, and Primal.
 *
 * The version of the OpenAPI document: 1.1
 * Contact: mail@spoonacular.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.spoonacular.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.spoonacular.client.JSON;

/**
 * GetRecipeNutritionWidgetByID200ResponseBadInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-11-03T17:09:45.164+01:00[Europe/Berlin]")
public class GetRecipeNutritionWidgetByID200ResponseBadInner {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private String amount;

  public static final String SERIALIZED_NAME_INDENTED = "indented";
  @SerializedName(SERIALIZED_NAME_INDENTED)
  private Boolean indented;

  public static final String SERIALIZED_NAME_PERCENT_OF_DAILY_NEEDS = "percentOfDailyNeeds";
  @SerializedName(SERIALIZED_NAME_PERCENT_OF_DAILY_NEEDS)
  private BigDecimal percentOfDailyNeeds;

  public GetRecipeNutritionWidgetByID200ResponseBadInner() { 
  }

  public GetRecipeNutritionWidgetByID200ResponseBadInner name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public GetRecipeNutritionWidgetByID200ResponseBadInner amount(String amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getAmount() {
    return amount;
  }


  public void setAmount(String amount) {
    this.amount = amount;
  }


  public GetRecipeNutritionWidgetByID200ResponseBadInner indented(Boolean indented) {
    
    this.indented = indented;
    return this;
  }

   /**
   * Get indented
   * @return indented
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public Boolean getIndented() {
    return indented;
  }


  public void setIndented(Boolean indented) {
    this.indented = indented;
  }


  public GetRecipeNutritionWidgetByID200ResponseBadInner percentOfDailyNeeds(BigDecimal percentOfDailyNeeds) {
    
    this.percentOfDailyNeeds = percentOfDailyNeeds;
    return this;
  }

   /**
   * Get percentOfDailyNeeds
   * @return percentOfDailyNeeds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public BigDecimal getPercentOfDailyNeeds() {
    return percentOfDailyNeeds;
  }


  public void setPercentOfDailyNeeds(BigDecimal percentOfDailyNeeds) {
    this.percentOfDailyNeeds = percentOfDailyNeeds;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetRecipeNutritionWidgetByID200ResponseBadInner getRecipeNutritionWidgetByID200ResponseBadInner = (GetRecipeNutritionWidgetByID200ResponseBadInner) o;
    return Objects.equals(this.name, getRecipeNutritionWidgetByID200ResponseBadInner.name) &&
        Objects.equals(this.amount, getRecipeNutritionWidgetByID200ResponseBadInner.amount) &&
        Objects.equals(this.indented, getRecipeNutritionWidgetByID200ResponseBadInner.indented) &&
        Objects.equals(this.percentOfDailyNeeds, getRecipeNutritionWidgetByID200ResponseBadInner.percentOfDailyNeeds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, amount, indented, percentOfDailyNeeds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetRecipeNutritionWidgetByID200ResponseBadInner {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    indented: ").append(toIndentedString(indented)).append("\n");
    sb.append("    percentOfDailyNeeds: ").append(toIndentedString(percentOfDailyNeeds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("name");
    openapiFields.add("amount");
    openapiFields.add("indented");
    openapiFields.add("percentOfDailyNeeds");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("amount");
    openapiRequiredFields.add("indented");
    openapiRequiredFields.add("percentOfDailyNeeds");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GetRecipeNutritionWidgetByID200ResponseBadInner
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (GetRecipeNutritionWidgetByID200ResponseBadInner.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetRecipeNutritionWidgetByID200ResponseBadInner is not found in the empty JSON string", GetRecipeNutritionWidgetByID200ResponseBadInner.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GetRecipeNutritionWidgetByID200ResponseBadInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetRecipeNutritionWidgetByID200ResponseBadInner` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : GetRecipeNutritionWidgetByID200ResponseBadInner.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("name") != null && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if (jsonObj.get("amount") != null && !jsonObj.get("amount").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `amount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("amount").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetRecipeNutritionWidgetByID200ResponseBadInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetRecipeNutritionWidgetByID200ResponseBadInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetRecipeNutritionWidgetByID200ResponseBadInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetRecipeNutritionWidgetByID200ResponseBadInner.class));

       return (TypeAdapter<T>) new TypeAdapter<GetRecipeNutritionWidgetByID200ResponseBadInner>() {
           @Override
           public void write(JsonWriter out, GetRecipeNutritionWidgetByID200ResponseBadInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetRecipeNutritionWidgetByID200ResponseBadInner read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetRecipeNutritionWidgetByID200ResponseBadInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetRecipeNutritionWidgetByID200ResponseBadInner
  * @throws IOException if the JSON string is invalid with respect to GetRecipeNutritionWidgetByID200ResponseBadInner
  */
  public static GetRecipeNutritionWidgetByID200ResponseBadInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetRecipeNutritionWidgetByID200ResponseBadInner.class);
  }

 /**
  * Convert an instance of GetRecipeNutritionWidgetByID200ResponseBadInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

