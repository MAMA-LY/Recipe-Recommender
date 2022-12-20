import 'package:flutter/widgets.dart';
import 'package:recipe_recommender_frontend/screens/account_settings.dart';
import 'package:recipe_recommender_frontend/screens/home.dart';
import 'package:recipe_recommender_frontend/screens/settings.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';

import 'screens/sign/signup.dart';

// We use name route
// All our routes will be available here
final Map<String, WidgetBuilder> routes = {
  SignInPage.routeName: (context) => const SignInPage(),
  //ForgotPasswordScreen.routeName: (context) => ForgotPasswordScreen(),
  SignUpPage.routeName: (context) => const SignUpPage(),
  AccountSettingsPage.routeName: (context) => const AccountSettingsPage(),
  //OtpScreen.routeName: (context) => OtpScreen(),
  HomePage.routeName: (context) => const HomePage(),
  SettingsPage.routeName: (context) => const SettingsPage(),
};
