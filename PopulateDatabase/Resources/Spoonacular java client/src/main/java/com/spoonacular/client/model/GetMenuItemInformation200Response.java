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
import com.spoonacular.client.model.SearchGroceryProductsByUPC200ResponseNutrition;
import com.spoonacular.client.model.SearchGroceryProductsByUPC200ResponseServings;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
public class GetMenuItemInformation200Response {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_RESTAURANT_CHAIN = "restaurantChain";
  @SerializedName(SERIALIZED_NAME_RESTAURANT_CHAIN)
  private String restaurantChain;

  public static final String SERIALIZED_NAME_NUTRITION = "nutrition";
  @SerializedName(SERIALIZED_NAME_NUTRITION)
  private SearchGroceryProductsByUPC200ResponseNutrition nutrition;

  public static final String SERIALIZED_NAME_BADGES = "badges";
  @SerializedName(SERIALIZED_NAME_BADGES)
  private List<String> badges = new ArrayList<>();

  public static final String SERIALIZED_NAME_BREADCRUMBS = "breadcrumbs";
  @SerializedName(SERIALIZED_NAME_BREADCRUMBS)
  private List<String> breadcrumbs = new ArrayList<>();

  public static final String SERIALIZED_NAME_GENERATED_TEXT = "generatedText";
  @SerializedName(SERIALIZED_NAME_GENERATED_TEXT)
  private String generatedText;

  public static final String SERIALIZED_NAME_IMAGE_TYPE = "imageType";
  @SerializedName(SERIALIZED_NAME_IMAGE_TYPE)
  private String imageType;

  public static final String SERIALIZED_NAME_LIKES = "likes";
  @SerializedName(SERIALIZED_NAME_LIKES)
  private BigDecimal likes;

  public static final String SERIALIZED_NAME_SERVINGS = "servings";
  @SerializedName(SERIALIZED_NAME_SERVINGS)
  private SearchGroceryProductsByUPC200ResponseServings servings;

  public static final String SERIALIZED_NAME_PRICE = "price";
  @SerializedName(SERIALIZED_NAME_PRICE)
  private BigDecimal price;

  public static final String SERIALIZED_NAME_SPOONACULAR_SCORE = "spoonacularScore";
  @SerializedName(SERIALIZED_NAME_SPOONACULAR_SCORE)
  private BigDecimal spoonacularScore;

  public GetMenuItemInformation200Response() { 
  }

  public GetMenuItemInformation200Response id(Integer id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public GetMenuItemInformation200Response title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public GetMenuItemInformation200Response restaurantChain(String restaurantChain) {
    
    this.restaurantChain = restaurantChain;
    return this;
  }

   /**
   * Get restaurantChain
   * @return restaurantChain
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getRestaurantChain() {
    return restaurantChain;
  }


  public void setRestaurantChain(String restaurantChain) {
    this.restaurantChain = restaurantChain;
  }


  public GetMenuItemInformation200Response nutrition(SearchGroceryProductsByUPC200ResponseNutrition nutrition) {
    
    this.nutrition = nutrition;
    return this;
  }

   /**
   * Get nutrition
   * @return nutrition
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public SearchGroceryProductsByUPC200ResponseNutrition getNutrition() {
    return nutrition;
  }


  public void setNutrition(SearchGroceryProductsByUPC200ResponseNutrition nutrition) {
    this.nutrition = nutrition;
  }


  public GetMenuItemInformation200Response badges(List<String> badges) {
    
    this.badges = badges;
    return this;
  }

  public GetMenuItemInformation200Response addBadgesItem(String badgesItem) {
    this.badges.add(badgesItem);
    return this;
  }

   /**
   * Get badges
   * @return badges
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<String> getBadges() {
    return badges;
  }


  public void setBadges(List<String> badges) {
    this.badges = badges;
  }


  public GetMenuItemInformation200Response breadcrumbs(List<String> breadcrumbs) {
    
    this.breadcrumbs = breadcrumbs;
    return this;
  }

  public GetMenuItemInformation200Response addBreadcrumbsItem(String breadcrumbsItem) {
    this.breadcrumbs.add(breadcrumbsItem);
    return this;
  }

   /**
   * Get breadcrumbs
   * @return breadcrumbs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<String> getBreadcrumbs() {
    return breadcrumbs;
  }


  public void setBreadcrumbs(List<String> breadcrumbs) {
    this.breadcrumbs = breadcrumbs;
  }


  public GetMenuItemInformation200Response generatedText(String generatedText) {
    
    this.generatedText = generatedText;
    return this;
  }

   /**
   * Get generatedText
   * @return generatedText
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGeneratedText() {
    return generatedText;
  }


  public void setGeneratedText(String generatedText) {
    this.generatedText = generatedText;
  }


  public GetMenuItemInformation200Response imageType(String imageType) {
    
    this.imageType = imageType;
    return this;
  }

   /**
   * Get imageType
   * @return imageType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getImageType() {
    return imageType;
  }


  public void setImageType(String imageType) {
    this.imageType = imageType;
  }


  public GetMenuItemInformation200Response likes(BigDecimal likes) {
    
    this.likes = likes;
    return this;
  }

   /**
   * Get likes
   * @return likes
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public BigDecimal getLikes() {
    return likes;
  }


  public void setLikes(BigDecimal likes) {
    this.likes = likes;
  }


  public GetMenuItemInformation200Response servings(SearchGroceryProductsByUPC200ResponseServings servings) {
    
    this.servings = servings;
    return this;
  }

   /**
   * Get servings
   * @return servings
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public SearchGroceryProductsByUPC200ResponseServings getServings() {
    return servings;
  }


  public void setServings(SearchGroceryProductsByUPC200ResponseServings servings) {
    this.servings = servings;
  }


  public GetMenuItemInformation200Response price(BigDecimal price) {
    
    this.price = price;
    return this;
  }

   /**
   * Get price
   * @return price
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BigDecimal getPrice() {
    return price;
  }


  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  public GetMenuItemInformation200Response spoonacularScore(BigDecimal spoonacularScore) {
    
    this.spoonacularScore = spoonacularScore;
    return this;
  }

   /**
   * Get spoonacularScore
   * @return spoonacularScore
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BigDecimal getSpoonacularScore() {
    return spoonacularScore;
  }


  public void setSpoonacularScore(BigDecimal spoonacularScore) {
    this.spoonacularScore = spoonacularScore;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetMenuItemInformation200Response getMenuItemInformation200Response = (GetMenuItemInformation200Response) o;
    return Objects.equals(this.id, getMenuItemInformation200Response.id) &&
        Objects.equals(this.title, getMenuItemInformation200Response.title) &&
        Objects.equals(this.restaurantChain, getMenuItemInformation200Response.restaurantChain) &&
        Objects.equals(this.nutrition, getMenuItemInformation200Response.nutrition) &&
        Objects.equals(this.badges, getMenuItemInformation200Response.badges) &&
        Objects.equals(this.breadcrumbs, getMenuItemInformation200Response.breadcrumbs) &&
        Objects.equals(this.generatedText, getMenuItemInformation200Response.generatedText) &&
        Objects.equals(this.imageType, getMenuItemInformation200Response.imageType) &&
        Objects.equals(this.likes, getMenuItemInformation200Response.likes) &&
        Objects.equals(this.servings, getMenuItemInformation200Response.servings) &&
        Objects.equals(this.price, getMenuItemInformation200Response.price) &&
        Objects.equals(this.spoonacularScore, getMenuItemInformation200Response.spoonacularScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, restaurantChain, nutrition, badges, breadcrumbs, generatedText, imageType, likes, servings, price, spoonacularScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetMenuItemInformation200Response {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    restaurantChain: ").append(toIndentedString(restaurantChain)).append("\n");
    sb.append("    nutrition: ").append(toIndentedString(nutrition)).append("\n");
    sb.append("    badges: ").append(toIndentedString(badges)).append("\n");
    sb.append("    breadcrumbs: ").append(toIndentedString(breadcrumbs)).append("\n");
    sb.append("    generatedText: ").append(toIndentedString(generatedText)).append("\n");
    sb.append("    imageType: ").append(toIndentedString(imageType)).append("\n");
    sb.append("    likes: ").append(toIndentedString(likes)).append("\n");
    sb.append("    servings: ").append(toIndentedString(servings)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    spoonacularScore: ").append(toIndentedString(spoonacularScore)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("title");
    openapiFields.add("restaurantChain");
    openapiFields.add("nutrition");
    openapiFields.add("badges");
    openapiFields.add("breadcrumbs");
    openapiFields.add("generatedText");
    openapiFields.add("imageType");
    openapiFields.add("likes");
    openapiFields.add("servings");
    openapiFields.add("price");
    openapiFields.add("spoonacularScore");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("title");
    openapiRequiredFields.add("restaurantChain");
    openapiRequiredFields.add("nutrition");
    openapiRequiredFields.add("badges");
    openapiRequiredFields.add("breadcrumbs");
    openapiRequiredFields.add("imageType");
    openapiRequiredFields.add("likes");
    openapiRequiredFields.add("servings");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GetMenuItemInformation200Response
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (GetMenuItemInformation200Response.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetMenuItemInformation200Response is not found in the empty JSON string", GetMenuItemInformation200Response.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GetMenuItemInformation200Response.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetMenuItemInformation200Response` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : GetMenuItemInformation200Response.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("title") != null && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if (jsonObj.get("restaurantChain") != null && !jsonObj.get("restaurantChain").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `restaurantChain` to be a primitive type in the JSON string but got `%s`", jsonObj.get("restaurantChain").toString()));
      }
      // validate the optional field `nutrition`
      if (jsonObj.getAsJsonObject("nutrition") != null) {
        SearchGroceryProductsByUPC200ResponseNutrition.validateJsonObject(jsonObj.getAsJsonObject("nutrition"));
      }
      // ensure the json data is an array
      if (jsonObj.get("badges") != null && !jsonObj.get("badges").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `badges` to be an array in the JSON string but got `%s`", jsonObj.get("badges").toString()));
      }
      // ensure the json data is an array
      if (jsonObj.get("breadcrumbs") != null && !jsonObj.get("breadcrumbs").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `breadcrumbs` to be an array in the JSON string but got `%s`", jsonObj.get("breadcrumbs").toString()));
      }
      if (jsonObj.get("generatedText") != null && !jsonObj.get("generatedText").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `generatedText` to be a primitive type in the JSON string but got `%s`", jsonObj.get("generatedText").toString()));
      }
      if (jsonObj.get("imageType") != null && !jsonObj.get("imageType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `imageType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("imageType").toString()));
      }
      // validate the optional field `servings`
      if (jsonObj.getAsJsonObject("servings") != null) {
        SearchGroceryProductsByUPC200ResponseServings.validateJsonObject(jsonObj.getAsJsonObject("servings"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetMenuItemInformation200Response.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetMenuItemInformation200Response' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetMenuItemInformation200Response> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetMenuItemInformation200Response.class));

       return (TypeAdapter<T>) new TypeAdapter<GetMenuItemInformation200Response>() {
           @Override
           public void write(JsonWriter out, GetMenuItemInformation200Response value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetMenuItemInformation200Response read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetMenuItemInformation200Response given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetMenuItemInformation200Response
  * @throws IOException if the JSON string is invalid with respect to GetMenuItemInformation200Response
  */
  public static GetMenuItemInformation200Response fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetMenuItemInformation200Response.class);
  }

 /**
  * Convert an instance of GetMenuItemInformation200Response to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

