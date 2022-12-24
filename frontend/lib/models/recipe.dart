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

  Recipe(
      {required this.name,
      required this.image,
      required this.id,
      this.tags,
      this.ingredients,
      this.nutrition,
      this.cuisine});

  factory Recipe.shortRecipeFromJson(dynamic json) {
    return Recipe(
      name: json['name'] as String,
      image: json['image'] as String,
      id: json['id'] as String,
    );
  }

  factory Recipe.recipeFromJson(dynamic json) {
    var jsonIngredients = json['ingredients'] as List;
    var jsonTags = json["tags"] as List;
    if (json['cuisine'] != null) {
      return Recipe(
          name: json['name'] as String,
          image: json['image'] as String,
          tags: jsonTags.map<String>((json) => json.toString()).toList(),
          id: json['id'] as String,
          cuisine: json['cuisine'] as String,
          nutrition: Nutrition.fromJson(json['nutrition']),
          ingredients: jsonIngredients
              .map<Ingredient>((json) => Ingredient.fromJson(json))
              .toList());
    } else {
      return Recipe(
          name: json['name'] as String,
          image: json['image'] as String,
          tags: jsonTags.map<String>((json) => json.toString()).toList(),
          id: json['id'] as String,
          nutrition: Nutrition.fromJson(json['nutrition']),
          ingredients: jsonIngredients
              .map<Ingredient>((json) => Ingredient.fromJson(json))
              .toList());
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
    return 'Recipe {name: $name, image: $image, tags: $tags, ID: $id, cuisine: $cuisine, nutrition: $nutrition, ingredients: $ingredients}';
  }
}
