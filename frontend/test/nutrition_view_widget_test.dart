import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/nutrition_view.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

void main() {
  testWidgets('Nutrition View smoke test', (WidgetTester tester) async {
    await tester.pumpWidget(MaterialApp(
        home: NutritionView(
            nutrition:
                Nutrition(calories: 26, proteins: 3, carbs: 6, fats: 8))));

    tester.pumpAndSettle();
  });
  testWidgets('Nutrition View inner widgets test', (WidgetTester tester) async {
    await tester.pumpWidget(MaterialApp(
        home: NutritionView(
            nutrition:
                Nutrition(calories: 26, proteins: 3, carbs: 6, fats: 8))));

    var text = find.byType(Text);
    expect(text, findsNWidgets(4));

    var sfCircularChart = find.byType(SfCircularChart);
    expect(sfCircularChart, findsOneWidget);
  });
}
