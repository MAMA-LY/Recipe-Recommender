import 'nutrition.dart';

class Ingredient {
  final String name;
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

  factory Ingredient.fromJson(dynamic json) {
    return Ingredient(
        name: json['name'] as String,
        id: json['id'] as String,
        icon: json['icon'] as String,
        amount: json['amount'] as String,
        nutrition: Nutrition.fromJson(json['nutrition']));
  }

  @override
  String toString() {
    return 'Recipe {name: $name, id: $id, icon: $icon, amount: $amount, nutrition: $nutrition}';
  }
}
