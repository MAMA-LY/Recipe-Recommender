import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:network_image_mock/network_image_mock.dart';
import 'package:recipe_recommender_frontend/screens/home.dart';

void main() {
  testWidgets('Home Page smoke test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async =>
        await tester.pumpWidget(const MaterialApp(home: HomePage())));

    tester.pumpAndSettle();
  });
  testWidgets('Home Page inner widgets test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async =>
        await tester.pumpWidget(const MaterialApp(home: HomePage())));

    var iconButton = find.byType(IconButton);
    expect(iconButton, findsOneWidget);

    var text = find.text("ورقة وقلم");
    expect(text, findsOneWidget);

    var icon = find.byIcon(Icons.analytics_outlined);
    expect(icon, findsOneWidget);
  });
}
