import 'package:flutter/material.dart';

import 'ingredient.dart';
import 'nutrition.dart';

class Recipe {
  final String name;
  final String ID;
  List<String>? tags;
  String? cuisine;
  List<Ingredient>? ingredients;
  final String photo;
  Nutrition? nutrition;

  Recipe({
    required this.name,
    required this.photo,
    required this.ID,
    this.tags,
    this.ingredients,
    this.nutrition,
    this.cuisine
  });

  factory Recipe.fromJson(dynamic json) {
    return Recipe(
        name: json['name'] as String,
        photo: json['photo'] as String,
        tags: json['tags'] as List<String>,
        ID: json['ID'] as String,
        cuisine: json['cuisine'] as String,
        nutrition: json['nutrition'] as Nutrition,
        ingredients: json['ingredients'] as List<Ingredient>);
  }

  static List<Recipe> recipesFromSnapshot(List<dynamic> snapshot) {
    debugPrint(snapshot.map((data) => Recipe.fromJson(data.toString())).toList().toString());
    return snapshot.map((data) => Recipe.fromJson(data.toString())).toList();
  }

  @override
  String toString() {
    return 'Recipe {name: $name, photo: $photo, tags: $tags, ID: $ID, cuisine: $cuisine, nutrition: $nutrition, ingredients: $ingredients}';
  }
}
