import 'dart:io';

import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/screens/nav/bottom_nav_screen.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:http/http.dart' as http;

import '../../main.dart';

class SettingsPage extends StatelessWidget {
  static String routeName = "/settings";
  const SettingsPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        onPressed: () async {
          var url = Uri.http("localhost:8080", "/signout");
          debugPrint(session.cookie);
          var response =
              await http.post(url, headers: {"cookie": session.cookie});
          debugPrint(response.statusCode.toString());
          Navigator.of(context, rootNavigator: true).pushReplacement(MaterialPageRoute(builder: (context) => const SignInPage()));
          cacheFile!.delete();
        },
        child: const Text("Sign out"));
  }
}
