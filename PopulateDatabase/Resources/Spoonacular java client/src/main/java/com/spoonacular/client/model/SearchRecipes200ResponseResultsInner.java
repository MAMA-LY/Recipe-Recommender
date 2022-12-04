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
 * SearchRecipes200ResponseResultsInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-11-03T17:09:45.164+01:00[Europe/Berlin]")
public class SearchRecipes200ResponseResultsInner {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_CALORIES = "calories";
  @SerializedName(SERIALIZED_NAME_CALORIES)
  private BigDecimal calories;

  public static final String SERIALIZED_NAME_CARBS = "carbs";
  @SerializedName(SERIALIZED_NAME_CARBS)
  private String carbs;

  public static final String SERIALIZED_NAME_FAT = "fat";
  @SerializedName(SERIALIZED_NAME_FAT)
  private String fat;

  public static final String SERIALIZED_NAME_IMAGE = "image";
  @SerializedName(SERIALIZED_NAME_IMAGE)
  private String image;

  public static final String SERIALIZED_NAME_IMAGE_TYPE = "imageType";
  @SerializedName(SERIALIZED_NAME_IMAGE_TYPE)
  private String imageType;

  public static final String SERIALIZED_NAME_PROTEIN = "protein";
  @SerializedName(SERIALIZED_NAME_PROTEIN)
  private String protein;

  public SearchRecipes200ResponseResultsInner() { 
  }

  public SearchRecipes200ResponseResultsInner id(Integer id) {
    
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


  public SearchRecipes200ResponseResultsInner title(String title) {
    
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


  public SearchRecipes200ResponseResultsInner calories(BigDecimal calories) {
    
    this.calories = calories;
    return this;
  }

   /**
   * Get calories
   * @return calories
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public BigDecimal getCalories() {
    return calories;
  }


  public void setCalories(BigDecimal calories) {
    this.calories = calories;
  }


  public SearchRecipes200ResponseResultsInner carbs(String carbs) {
    
    this.carbs = carbs;
    return this;
  }

   /**
   * Get carbs
   * @return carbs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getCarbs() {
    return carbs;
  }


  public void setCarbs(String carbs) {
    this.carbs = carbs;
  }


  public SearchRecipes200ResponseResultsInner fat(String fat) {
    
    this.fat = fat;
    return this;
  }

   /**
   * Get fat
   * @return fat
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getFat() {
    return fat;
  }


  public void setFat(String fat) {
    this.fat = fat;
  }


  public SearchRecipes200ResponseResultsInner image(String image) {
    
    this.image = image;
    return this;
  }

   /**
   * Get image
   * @return image
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getImage() {
    return image;
  }


  public void setImage(String image) {
    this.image = image;
  }


  public SearchRecipes200ResponseResultsInner imageType(String imageType) {
    
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


  public SearchRecipes200ResponseResultsInner protein(String protein) {
    
    this.protein = protein;
    return this;
  }

   /**
   * Get protein
   * @return protein
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getProtein() {
    return protein;
  }


  public void setProtein(String protein) {
    this.protein = protein;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRecipes200ResponseResultsInner searchRecipes200ResponseResultsInner = (SearchRecipes200ResponseResultsInner) o;
    return Objects.equals(this.id, searchRecipes200ResponseResultsInner.id) &&
        Objects.equals(this.title, searchRecipes200ResponseResultsInner.title) &&
        Objects.equals(this.calories, searchRecipes200ResponseResultsInner.calories) &&
        Objects.equals(this.carbs, searchRecipes200ResponseResultsInner.carbs) &&
        Objects.equals(this.fat, searchRecipes200ResponseResultsInner.fat) &&
        Objects.equals(this.image, searchRecipes200ResponseResultsInner.image) &&
        Objects.equals(this.imageType, searchRecipes200ResponseResultsInner.imageType) &&
        Objects.equals(this.protein, searchRecipes200ResponseResultsInner.protein);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, calories, carbs, fat, image, imageType, protein);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRecipes200ResponseResultsInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    calories: ").append(toIndentedString(calories)).append("\n");
    sb.append("    carbs: ").append(toIndentedString(carbs)).append("\n");
    sb.append("    fat: ").append(toIndentedString(fat)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    imageType: ").append(toIndentedString(imageType)).append("\n");
    sb.append("    protein: ").append(toIndentedString(protein)).append("\n");
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
    openapiFields.add("calories");
    openapiFields.add("carbs");
    openapiFields.add("fat");
    openapiFields.add("image");
    openapiFields.add("imageType");
    openapiFields.add("protein");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("title");
    openapiRequiredFields.add("calories");
    openapiRequiredFields.add("carbs");
    openapiRequiredFields.add("fat");
    openapiRequiredFields.add("image");
    openapiRequiredFields.add("imageType");
    openapiRequiredFields.add("protein");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to SearchRecipes200ResponseResultsInner
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (SearchRecipes200ResponseResultsInner.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in SearchRecipes200ResponseResultsInner is not found in the empty JSON string", SearchRecipes200ResponseResultsInner.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!SearchRecipes200ResponseResultsInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SearchRecipes200ResponseResultsInner` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SearchRecipes200ResponseResultsInner.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("title") != null && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if (jsonObj.get("carbs") != null && !jsonObj.get("carbs").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `carbs` to be a primitive type in the JSON string but got `%s`", jsonObj.get("carbs").toString()));
      }
      if (jsonObj.get("fat") != null && !jsonObj.get("fat").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fat` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fat").toString()));
      }
      if (jsonObj.get("image") != null && !jsonObj.get("image").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `image` to be a primitive type in the JSON string but got `%s`", jsonObj.get("image").toString()));
      }
      if (jsonObj.get("imageType") != null && !jsonObj.get("imageType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `imageType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("imageType").toString()));
      }
      if (jsonObj.get("protein") != null && !jsonObj.get("protein").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `protein` to be a primitive type in the JSON string but got `%s`", jsonObj.get("protein").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SearchRecipes200ResponseResultsInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SearchRecipes200ResponseResultsInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SearchRecipes200ResponseResultsInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SearchRecipes200ResponseResultsInner.class));

       return (TypeAdapter<T>) new TypeAdapter<SearchRecipes200ResponseResultsInner>() {
           @Override
           public void write(JsonWriter out, SearchRecipes200ResponseResultsInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SearchRecipes200ResponseResultsInner read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SearchRecipes200ResponseResultsInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SearchRecipes200ResponseResultsInner
  * @throws IOException if the JSON string is invalid with respect to SearchRecipes200ResponseResultsInner
  */
  public static SearchRecipes200ResponseResultsInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SearchRecipes200ResponseResultsInner.class);
  }

 /**
  * Convert an instance of SearchRecipes200ResponseResultsInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
