import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:network_image_mock/network_image_mock.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/favorites.dart';
import 'package:recipe_recommender_frontend/screens/home.dart';
import 'package:recipe_recommender_frontend/screens/meal_calendar.dart';
import 'package:recipe_recommender_frontend/screens/page_view_controller.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/recipe_page.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/ingredients_view.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/nutrition_view.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/recipe_title.dart';
import 'package:recipe_recommender_frontend/screens/search.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:recipe_recommender_frontend/screens/sign/signup.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';
import 'package:recipe_recommender_frontend/screens/widgets/recipe_card.dart';
// ignore: import_of_legacy_library_into_null_safe
import 'package:syncfusion_flutter_charts/charts.dart';

void main() {
  testWidgets('Signin Page smoke test', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(home: SignInPage()));
    await tester.pumpAndSettle();
  });
  testWidgets('Signin Page inner widgets test', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(home: SignInPage()));

    var text = find.text('Don\'t have an account?');
    expect(text, findsOneWidget);

    var center = find.byType(Center);
    expect(center, findsOneWidget);

    var customTextField = find.byType(CustomButton);
    expect(customTextField, findsOneWidget);
  });

  testWidgets('Signup Page smoke test', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(home: SignUpPage()));
    await tester.pumpAndSettle();
  });
  testWidgets('Signup Page inner widgets test', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(home: SignUpPage()));

    var text = find.text('Sign in');
    expect(text, findsOneWidget);

    var center = find.byType(Center);
    expect(center, findsOneWidget);

    var customTextField = find.byType(CustomButton);
    expect(customTextField, findsOneWidget);

    var image = find.byType(Image);
    expect(image, findsOneWidget);
  });

  testWidgets('Recipe Card smoke test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async => await tester.pumpWidget(MaterialApp(
        home: RecipeCard(
            name: "shakshouka",
            thumbnailUrl: "https://i.picsum.photos/id/1/5000/3333.jpg",
            id: "5465465"))));

    tester.pumpAndSettle();
  });
  testWidgets('Recipe Card inner widgets test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async => await tester.pumpWidget(MaterialApp(
        home: RecipeCard(
            name: "shakshouka",
            thumbnailUrl: "https://i.picsum.photos/id/1/5000/3333.jpg",
            id: "5465465"))));

    var textButton = find.byType(TextButton);
    expect(textButton, findsOneWidget);

    var text = find.text("shakshouka");
    expect(text, findsOneWidget);

    var align = find.byType(Align);
    expect(align, findsNWidgets(2));
  });

  testWidgets('Recipe Title smoke test', (WidgetTester tester) async {
    await tester.pumpWidget(MaterialApp(
        home: RecipeTitle(
            recipe: Recipe(
                name: "pizza",
                image:
                    "https://welcome2jordan.com/wp-content/uploads/2022/09/Shakshuka-Recipe-Welcome2Jordan.jpg",
                id: "125",
                tags: ["dairy free", "breakfast"]),
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
                tags: ["dairy free", "breakfast"]),
            padding: 0.5)));

    var text = find.text('pizza');
    expect(text, findsOneWidget);

    var icon = find.byIcon(Icons.fastfood_outlined);
    expect(icon, findsOneWidget);

    var row = find.byType(Row);
    expect(row, findsNWidgets(4));

    var col = find.byType(Column);
    expect(col, findsOneWidget);

    var sizedBox = find.byType(SizedBox);
    expect(sizedBox, findsNWidgets(5));
  });

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

  testWidgets('Page View Controller smoke test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async =>
        await tester.pumpWidget(const MaterialApp(home: PageViewController())));
    tester.pumpAndSettle();
  });
  testWidgets('Page View Controller inner widgets test',
      (WidgetTester tester) async {
    await mockNetworkImagesFor(() async =>
        await tester.pumpWidget(const MaterialApp(home: PageViewController())));

    var icon = find.byType(Icon);
    expect(icon, findsNWidgets(6));

    var homePage = find.byType(HomePage);
    expect(homePage, findsOneWidget);

    var bottomNavigationBar = find.byType(BottomNavigationBar);
    expect(bottomNavigationBar, findsOneWidget);

    var pageView = find.byType(PageView);
    expect(pageView, findsOneWidget);
  });
}
