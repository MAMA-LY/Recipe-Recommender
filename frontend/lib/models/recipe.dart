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

  Recipe({
    required this.name,
    required this.image,
    required this.id,
    this.tags,
    this.ingredients,
    this.nutrition,
    this.cuisine
  });

  factory Recipe.shortRecipeFromJson(dynamic json) {
    return Recipe(
        name: json['name'] as String,
        image: json['image'] as String,
        id: json['id'] as String,
    );
  }

  factory Recipe.recipeFromJson(dynamic json) {
    return Recipe(
        name: json['name'] as String,
        image: json['image'] as String,
        tags: json['tag'] as List<String>,
        id: json['id'] as String,
        cuisine: json['cuisine'] as String,
        nutrition: json['nutrition'] as Nutrition,
        ingredients: json['ingredients'] as List<Ingredient>);
  }

  static List<Recipe> shortRecipesFromSnapshot(List<dynamic> snapshot) {
    snapshot = snapshot.sublist(0, 20).where((element) => element['image'] != null).toList();
    return snapshot.map((data) {
      return Recipe.shortRecipeFromJson(data);
    }).toList();
  }

  static List<Recipe> recipesFromSnapshot(List<dynamic> snapshot) {
    return snapshot.map((data) {
      return Recipe.recipeFromJson(data);
    }).toList();
  }

  @override
  String toString() {
    return 'Recipe {name: $name, image: $image, tags: $tags, ID: $id, cuisine: $cuisine, nutrition: $nutrition, ingredients: $ingredients}';
  }
}
