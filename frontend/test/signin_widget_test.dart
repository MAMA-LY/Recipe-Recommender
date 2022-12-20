import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';

class SigninWidgetTest {
  static void run() {
    testWidgets('Signin Page smoke test', (WidgetTester tester) async {
      await tester.pumpWidget(const MaterialApp(home: SignInPage()));

      var text = find.text('Don\'t have an account?');
      expect(text, findsOneWidget);

      var center = find.byType(Center);
      expect(center, findsOneWidget);

      var customTextField = find.byType(BoxShadow);
      expect(customTextField, findsOneWidget);

      var image = find.byType(Image);
      expect(image, findsOneWidget);
    });
  }
}
