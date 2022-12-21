import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:network_image_mock/network_image_mock.dart';
import 'package:recipe_recommender_frontend/models/ingredient.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/recipe_page.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/ingredients_view.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/nutrition_view.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/recipe_image.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/recipe_title.dart';

void main() {
  testWidgets('Recipe Page smoke test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async => await tester.pumpWidget(MaterialApp(
        home: RecipePage(
            recipe: Recipe(
                name: "pizza",
                image: "https://i.picsum.photos/id/1/5000/3333.jpg",
                id: "23541",
                tags: ["dairy free", "breakfast"],
                nutrition:
                    Nutrition(calories: 50, fats: 30, carbs: 25, proteins: 12),
                ingredients: [
                  Ingredient(
                      name: "tomato",
                      id: "12222",
                      icon: "icon",
                      amount: "3 pieces of tomatos",
                      nutrition: Nutrition(
                          calories: 18, fats: 20, carbs: 9, proteins: 6)),
                  Ingredient(
                      name: "egg",
                      id: "12222",
                      icon: "icon",
                      amount: "3 eggs",
                      nutrition: Nutrition(
                          calories: 18, fats: 20, carbs: 9, proteins: 6))
                ]),
            inFavorites: false))));

    tester.pumpAndSettle();
  });
  testWidgets('Recipe Page inner widgets test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async => await tester.pumpWidget(MaterialApp(
        home: RecipePage(
            recipe: Recipe(
                name: "pizza",
                image: "https://i.picsum.photos/id/1/5000/3333.jpg",
                id: "23541",
                tags: ["dairy free", "breakfast"],
                nutrition:
                    Nutrition(calories: 50, fats: 30, carbs: 25, proteins: 12),
                ingredients: [
                  Ingredient(
                      name: "tomato",
                      id: "12222",
                      icon: "icon",
                      amount: "3 pieces of tomatos",
                      nutrition: Nutrition(
                          calories: 18, fats: 20, carbs: 9, proteins: 6)),
                  Ingredient(
                      name: "egg",
                      id: "12222",
                      icon: "icon",
                      amount: "3 eggs",
                      nutrition: Nutrition(
                          calories: 18, fats: 20, carbs: 9, proteins: 6))
                ]),
            inFavorites: false))));

    var sliverAppBar = find.byType(SliverAppBar);
    expect(sliverAppBar, findsOneWidget);

    var nutritionView = find.byType(NutritionView, skipOffstage: false);
    expect(nutritionView, findsOneWidget);

    var recipeImage = find.byType(RecipeImage, skipOffstage: false);
    expect(recipeImage, findsOneWidget);

    var recipeTitle = find.byType(RecipeTitle, skipOffstage: false);
    expect(recipeTitle, findsOneWidget);

    var ingredientsView = find.byType(IngredientsView, skipOffstage: false);
    expect(ingredientsView, findsOneWidget);
  });
}
