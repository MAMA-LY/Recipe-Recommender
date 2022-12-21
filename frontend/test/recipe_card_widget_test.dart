import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:network_image_mock/network_image_mock.dart';
import 'package:recipe_recommender_frontend/screens/widgets/recipe_card.dart';

void main() {
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
}
