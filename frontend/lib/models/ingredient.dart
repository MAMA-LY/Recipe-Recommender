import 'nutrition.dart';

class Ingredient {
  final String name;
  final String ID;
  final String icon;
  final int weight;
  final Nutrition nutrition;

  Ingredient(
      {required this.name,
        required this.ID,
        required this.icon,
        required this.weight,
        required this.nutrition});

  factory Ingredient.fromJson(dynamic json) {
    return Ingredient(
        name: json['name'] as String,
        ID: json['ID'] as String,
        icon: json['icon'] as String,
        weight: json['weight'] as int,
        nutrition: json['nutrition'] as Nutrition);
  }

  @override
  String toString() {
    return 'Recipe {name: $name, ID: $ID, icon: $icon, weight: $weight, nutrition: $nutrition}';
  }
}
