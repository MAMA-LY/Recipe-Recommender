import 'nutrition.dart';

class Ingredient {
  final String name;
  final String ID;
  final String icon;
  final String amount;
  final Nutrition nutrition;

  Ingredient(
      {required this.name,
        required this.ID,
        required this.icon,
        required this.amount,
        required this.nutrition});

  factory Ingredient.fromJson(dynamic json) {
    return Ingredient(
        name: json['name'] as String,
        ID: json['ID'] as String,
        icon: json['icon'] as String,
        amount: json['amount'] as String,
        nutrition: json['nutrition'] as Nutrition);
  }

  @override
  String toString() {
    return 'Recipe {name: $name, ID: $ID, icon: $icon, amount: $amount, nutrition: $nutrition}';
  }
}
