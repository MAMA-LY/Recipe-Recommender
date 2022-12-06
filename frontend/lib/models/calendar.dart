import 'package:flutter/cupertino.dart';

import 'ingredient.dart';
import 'recipe.dart';

class Calendar {
  List<Ingredient>? ingredients;
  List<Recipe>? recipes;

  Calendar({@required this.ingredients, @required this.recipes});

  factory Calendar.fromJson(dynamic json) {
    return Calendar(
        ingredients: json['ingredients'] as List<Ingredient>,
        recipes: json['recipes'] as List<Recipe>);
  }

  @override
  String toString() {
    return 'Recipe {ingredients: $ingredients, recipes: $recipes}';
  }
}
