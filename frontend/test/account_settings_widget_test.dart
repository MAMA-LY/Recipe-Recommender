import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:network_image_mock/network_image_mock.dart';
import 'package:recipe_recommender_frontend/screens/account_settings.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

void main() {
  testWidgets('Account Page smoke test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async =>
    await tester.pumpWidget(const MaterialApp(home: AccountSettingsPage())));

    tester.pumpAndSettle();
  });
  testWidgets('Account Page inner widgets test', (WidgetTester tester) async {
    await mockNetworkImagesFor(() async =>
    await tester.pumpWidget(const MaterialApp(home: AccountSettingsPage())));

    var iconButton = find.byType(IconButton);
    expect(iconButton, findsOneWidget);

    var column = find.byType(Column);
    expect(column, findsOneWidget);

    var row = find.byType(Row);
    expect(row, findsOneWidget);
    var sizedBox = find.byType(SizedBox);
    expect(sizedBox, findsOneWidget);
    var align = find.byType(Align);
    expect(align, findsOneWidget);

  });
}
