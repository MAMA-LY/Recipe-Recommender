import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:network_image_mock/network_image_mock.dart';
import 'package:recipe_recommender_frontend/screens/home.dart';
import 'package:recipe_recommender_frontend/screens/page_view_controller.dart';

void main() {
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
