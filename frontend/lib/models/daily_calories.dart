class DailyCalories {
  final int calories;
  final int proteins;
  final int carbs;
  final int fats;
  final int remaining;

  DailyCalories(
      {required this.calories,
      required this.proteins,
      required this.carbs,
      required this.fats,
      required this.remaining});

  @override
  String toString() {
    return 'DailyCalories {calories: $calories, proteins: $proteins, carbs: $carbs, fats: $fats, remaining: $remaining}';
  }
}
