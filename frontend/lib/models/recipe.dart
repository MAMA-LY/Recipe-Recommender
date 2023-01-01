import 'package:flutter/material.dart';

import 'ingredient.dart';
import 'nutrition.dart';

class Recipe {
  final String name;
  final String id;
  List<String>? tags;
  String? cuisine;
  List<Ingredient>? ingredients;
  final String image;
  Nutrition? nutrition;
  double rate;
  int rates_count;
  double currentUserCount;
  bool? favourite;

  Recipe(
      {required this.name,
      required this.image,
      required this.id,
      this.tags,
      this.ingredients,
      this.nutrition,
      this.cuisine,
      this.rate = 0,
      this.rates_count = 0,
      this.currentUserCount = 0,
      this.favourite});

  factory Recipe.shortRecipeFromJson(dynamic json) {
    return Recipe(
      name: json['name'] as String,
      image: json['image'] as String,
      id: json['id'] as String,
    );
  }

  factory Recipe.recipeFromJson(dynamic json) {
    debugPrint("JSON\n");
    debugPrint("JSON\n");
    debugPrint(json.toString());
    debugPrint(json['id'] as String);
    var jsonIngredients = json['ingredients'] as List;
    var jsonTags = json["tags"] as List;
    if (json['cuisine'] != null) {
      return Recipe(
          name: json['name'] as String,
          image: json['image'] as String,
          tags: jsonTags.map<String>((json) => json.toString()).toList(),
          id: json['id'] as String,
          favourite: json['favourite'] as bool,
          cuisine: json['cuisine'] as String,
          nutrition: Nutrition.fromJson(json['nutrition']),
          ingredients: jsonIngredients
              .map<Ingredient>((json) => Ingredient.fromJson(json))
              .toList(),
          rate: json['rate'] as double,
          rates_count: json['rates_count'] as int,
          currentUserCount: json['currentUserCount'] as double);
    } else {
      return Recipe(
          name: json['name'] as String,
          image: json['image'] as String,
          tags: jsonTags.map<String>((json) => json.toString()).toList(),
          id: json['id'] as String,
          favourite: json['favourite'] as bool,
          nutrition: Nutrition.fromJson(json['nutrition']),
          ingredients: jsonIngredients
              .map<Ingredient>((json) => Ingredient.fromJson(json))
              .toList(),
          rate: json['rate'] as double,
          rates_count: json['rates_count'] as int,
          currentUserCount: json['currentUserCount'] as double);
    }
  }

  static List<Recipe> shortRecipesFromSnapshot(List<dynamic> snapshot) {
    return snapshot.map((data) {
      return Recipe.shortRecipeFromJson(data);
    }).toList();
  }

  static List<Recipe> recipesFromSnapshot(List<dynamic> snapshot) {
    return snapshot.map((data) {
      return Recipe.recipeFromJson(data);
    }).toList();
  }

  String getTags() {
    String tagsList = "";
    for (var tag in tags!) {
      tagsList += ", $tag";
    }
    return tagsList.substring(1);
  }

  @override
  String toString() {
    return 'Recipe {name: $name, image: $image, tags: $tags, ID: $id, cuisine: $cuisine, nutrition: $nutrition, ingredients: $ingredients, favourite : $favourite}';
  }
}
