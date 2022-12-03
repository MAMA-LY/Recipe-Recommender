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
import com.spoonacular.client.model.GetWinePairing200ResponseProductMatchesInner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
 * 
 */
@ApiModel(description = "")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-11-03T17:09:45.164+01:00[Europe/Berlin]")
public class GetWinePairing200Response {
  public static final String SERIALIZED_NAME_PAIRED_WINES = "pairedWines";
  @SerializedName(SERIALIZED_NAME_PAIRED_WINES)
  private List<String> pairedWines = new ArrayList<>();

  public static final String SERIALIZED_NAME_PAIRING_TEXT = "pairingText";
  @SerializedName(SERIALIZED_NAME_PAIRING_TEXT)
  private String pairingText;

  public static final String SERIALIZED_NAME_PRODUCT_MATCHES = "productMatches";
  @SerializedName(SERIALIZED_NAME_PRODUCT_MATCHES)
  private Set<GetWinePairing200ResponseProductMatchesInner> productMatches = new LinkedHashSet<>();

  public GetWinePairing200Response() { 
  }

  public GetWinePairing200Response pairedWines(List<String> pairedWines) {
    
    this.pairedWines = pairedWines;
    return this;
  }

  public GetWinePairing200Response addPairedWinesItem(String pairedWinesItem) {
    this.pairedWines.add(pairedWinesItem);
    return this;
  }

   /**
   * Get pairedWines
   * @return pairedWines
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<String> getPairedWines() {
    return pairedWines;
  }


  public void setPairedWines(List<String> pairedWines) {
    this.pairedWines = pairedWines;
  }


  public GetWinePairing200Response pairingText(String pairingText) {
    
    this.pairingText = pairingText;
    return this;
  }

   /**
   * Get pairingText
   * @return pairingText
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getPairingText() {
    return pairingText;
  }


  public void setPairingText(String pairingText) {
    this.pairingText = pairingText;
  }


  public GetWinePairing200Response productMatches(Set<GetWinePairing200ResponseProductMatchesInner> productMatches) {
    
    this.productMatches = productMatches;
    return this;
  }

  public GetWinePairing200Response addProductMatchesItem(GetWinePairing200ResponseProductMatchesInner productMatchesItem) {
    this.productMatches.add(productMatchesItem);
    return this;
  }

   /**
   * Get productMatches
   * @return productMatches
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public Set<GetWinePairing200ResponseProductMatchesInner> getProductMatches() {
    return productMatches;
  }


  public void setProductMatches(Set<GetWinePairing200ResponseProductMatchesInner> productMatches) {
    this.productMatches = productMatches;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetWinePairing200Response getWinePairing200Response = (GetWinePairing200Response) o;
    return Objects.equals(this.pairedWines, getWinePairing200Response.pairedWines) &&
        Objects.equals(this.pairingText, getWinePairing200Response.pairingText) &&
        Objects.equals(this.productMatches, getWinePairing200Response.productMatches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pairedWines, pairingText, productMatches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetWinePairing200Response {\n");
    sb.append("    pairedWines: ").append(toIndentedString(pairedWines)).append("\n");
    sb.append("    pairingText: ").append(toIndentedString(pairingText)).append("\n");
    sb.append("    productMatches: ").append(toIndentedString(productMatches)).append("\n");
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
    openapiFields.add("pairedWines");
    openapiFields.add("pairingText");
    openapiFields.add("productMatches");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("pairedWines");
    openapiRequiredFields.add("pairingText");
    openapiRequiredFields.add("productMatches");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GetWinePairing200Response
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (GetWinePairing200Response.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetWinePairing200Response is not found in the empty JSON string", GetWinePairing200Response.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GetWinePairing200Response.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetWinePairing200Response` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : GetWinePairing200Response.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // ensure the json data is an array
      if (jsonObj.get("pairedWines") != null && !jsonObj.get("pairedWines").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `pairedWines` to be an array in the JSON string but got `%s`", jsonObj.get("pairedWines").toString()));
      }
      if (jsonObj.get("pairingText") != null && !jsonObj.get("pairingText").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pairingText` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pairingText").toString()));
      }
      JsonArray jsonArrayproductMatches = jsonObj.getAsJsonArray("productMatches");
      if (jsonArrayproductMatches != null) {
        // ensure the json data is an array
        if (!jsonObj.get("productMatches").isJsonArray()) {
          throw new IllegalArgumentException(String.format("Expected the field `productMatches` to be an array in the JSON string but got `%s`", jsonObj.get("productMatches").toString()));
        }

        // validate the optional field `productMatches` (array)
        for (int i = 0; i < jsonArrayproductMatches.size(); i++) {
          GetWinePairing200ResponseProductMatchesInner.validateJsonObject(jsonArrayproductMatches.get(i).getAsJsonObject());
        };
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetWinePairing200Response.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetWinePairing200Response' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetWinePairing200Response> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetWinePairing200Response.class));

       return (TypeAdapter<T>) new TypeAdapter<GetWinePairing200Response>() {
           @Override
           public void write(JsonWriter out, GetWinePairing200Response value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetWinePairing200Response read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetWinePairing200Response given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetWinePairing200Response
  * @throws IOException if the JSON string is invalid with respect to GetWinePairing200Response
  */
  public static GetWinePairing200Response fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetWinePairing200Response.class);
  }

 /**
  * Convert an instance of GetWinePairing200Response to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

