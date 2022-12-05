import 'dart:io';

import 'package:flutter/material.dart';
import 'package:path_provider/path_provider.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/cookieManager.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:recipe_recommender_frontend/screens/splash_screen/splash_screen.dart';
import 'api/session.dart';
import 'screens/nav/bottom_nav_screen.dart';
import 'package:http/http.dart' as http;

var session = Session("");

String cookieStr = "";
File? cacheFile;
Future<String> getLocalPath() async {
  final directory = await getTemporaryDirectory();
  return directory.path;
}

Future<File> getLocalFile() async {
  final path = await getLocalPath();
  return File('$path/cookie.txt').create();
}

void main() {
  getLocalFile().then((value) => {
        cacheFile = value,
        cookieStr = cacheFile!.readAsStringSync(),
        runApp(MaterialApp(
          debugShowCheckedModeBanner: false,
          theme: ThemeData(
            fontFamily: 'Satoshi',
            primarySwatch: Colors.orange,
            primaryColor: Constants.primaryColor,
            textTheme: const TextTheme(
              headline1: TextStyle(
                fontFamily: 'Telma',
                fontSize: 24,
                fontWeight: FontWeight.bold,
                color: Constants.primaryColor,
              ),
            ),
          ),
          home: const MyApp(),
        ))
      }).onError((error, stackTrace) => {debugPrint(error.toString())});
}

Future<String?> getServerInitResponse() async {
  session.cookie = cookieStr;
  var url = Uri.http("localhost:8080", "/home");
  var serverResponse = await http.get(url, headers: {"cookie": cookieStr});
  final bool hasData = serverResponse.body != null;
  if (hasData) {
    return serverResponse.body;
  } else {
    return null; // null tells FutureBuilder that no data is stored
  }
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      body: FutureBuilder(
        future: getServerInitResponse(),
        initialData: "",
        builder: (builder, snapshot) {
          if (snapshot.hasData) {
            String response = snapshot.data!;
            if (response == "UserInfo") {
              return const BottomNavView();
            } else {
              return const SignInPage();
            }
          } else {
            return const SplashScreenPage();
          }
        },
      ),
    );

  }
}
