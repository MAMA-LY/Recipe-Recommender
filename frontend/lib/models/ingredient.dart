import 'nutrition.dart';

class Ingredient {
  final String name;
<<<<<<< HEAD
  final String id;
  final String icon;
  final String amount;
  final Nutrition nutrition;

  Ingredient(
      {required this.name,
        required this.id,
        required this.icon,
        required this.amount,
        required this.nutrition});
=======
  final String? id;
  final String? icon;
  final String? amount;
  final Nutrition? nutrition;

  Ingredient(
      {required this.name, this.id, this.icon, this.amount, this.nutrition});
>>>>>>> main

  factory Ingredient.fromJson(dynamic json) {
    return Ingredient(
        name: json['name'] as String,
        id: json['id'] as String,
        icon: json['icon'] as String,
        amount: json['amount'] as String,
<<<<<<< HEAD
        nutrition: json['nutrition'] as Nutrition);
=======
        nutrition: Nutrition.fromJson(json['nutrition']));
  }

  static String ingredientNamesFromJson(dynamic json) {
    return json as String;
  }

  static List<String> ingredientsFromSnapshot(List<dynamic> snapshot) {
    return snapshot.map((data) {
      return Ingredient.ingredientNamesFromJson(data);
    }).toList();
>>>>>>> main
  }

  @override
  String toString() {
    return 'Recipe {name: $name, id: $id, icon: $icon, amount: $amount, nutrition: $nutrition}';
  }
}
