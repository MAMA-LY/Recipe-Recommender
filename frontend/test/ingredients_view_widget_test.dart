import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/ingredients_view.dart';

void main() {
  testWidgets('Ingredients View smoke test', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(
        home: IngredientsView(ingredients: ["3 eggs", "2 cups of water"])));

    tester.pumpAndSettle();
  });
  testWidgets('Ingredients View inner widgets test',
      (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(
        home: IngredientsView(ingredients: ["3 eggs", "2 cups of water"])));

    var icon = find.byIcon(Icons.done);
    expect(icon, findsNWidgets(2));

    var listView = find.byType(ListView);
    expect(listView, findsOneWidget);

    var sizedBox = find.byType(SizedBox);
    expect(sizedBox, findsNWidgets(6));
  });
}
