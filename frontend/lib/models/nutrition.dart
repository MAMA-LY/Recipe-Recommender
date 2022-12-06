class Nutrition {
  final int calories;
  final int proteins;
  final int carbs;
  final int fats;

  Nutrition(
      {required this.calories,
      required this.proteins,
      required this.carbs,
      required this.fats});

  factory Nutrition.fromJson(dynamic json) {
    return Nutrition(
        calories: json['calories'] as int,
        proteins: json['proteins'] as int,
        carbs: json['carbs'] as int,
        fats: json['fats'] as int);
  }

  @override
  String toString() {
    return 'Recipe {calories: $calories, proteins: $proteins, carbs: $carbs, fats: $fats}';
  }
}
