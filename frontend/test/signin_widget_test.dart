import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';

void main() {
  testWidgets('Signin Page smoke test', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(
        home: SignInPage(
      initResp: '',
    )));
    await tester.pumpAndSettle();
  });
  testWidgets('Signin Page inner widgets test', (WidgetTester tester) async {
    await tester.pumpWidget(const MaterialApp(
        home: SignInPage(
      initResp: '',
    )));

    var text = find.text('Don\'t have an account?');
    expect(text, findsOneWidget);

    var center = find.byType(Center);
    expect(center, findsOneWidget);

    var customTextField = find.byType(CustomButton);
    expect(customTextField, findsOneWidget);
  });
}
