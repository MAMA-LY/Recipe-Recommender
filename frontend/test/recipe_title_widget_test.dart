import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/recipe_title.dart';

void main() {
  testWidgets('Recipe Title smoke test', (WidgetTester tester) async {
    await tester.pumpWidget(MaterialApp(
        home: RecipeTitle(
            recipe: Recipe(
                name: "pizza",
                image:
                    "https://welcome2jordan.com/wp-content/uploads/2022/09/Shakshuka-Recipe-Welcome2Jordan.jpg",
                id: "125",
                tags: ["dairy free", "breakfast"], favourite: false),
            padding: 0.5)));

    tester.pumpAndSettle();
  });
  testWidgets('Recipe Title inner widgets test', (WidgetTester tester) async {
    await tester.pumpWidget(MaterialApp(
        home: RecipeTitle(
            recipe: Recipe(
                name: "pizza",
                image:
                    "https://welcome2jordan.com/wp-content/uploads/2022/09/Shakshuka-Recipe-Welcome2Jordan.jpg",
                id: "125",
                tags: ["dairy free", "breakfast"], favourite: true),
            padding: 0.5)));

    var text = find.text('pizza');
    expect(text, findsOneWidget);
  });
}
