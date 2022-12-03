import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'screens/nav/bottom_nav_screen.dart';

void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    theme: ThemeData(
      fontFamily: 'Satoshi',
      primarySwatch: Colors.blue,
      primaryColor: Colors.redAccent,

      textTheme: const TextTheme(
        headline1: TextStyle(
          fontFamily: 'Telma',
          fontSize: 24,
          fontWeight: FontWeight.bold,
          color: Colors.redAccent,
        ),
      ),
    ),
    home: const MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const SignInPage();
  }
}
