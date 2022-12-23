import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:recipe_recommender_frontend/screens/sign/signup.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';

void main() {
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
}
