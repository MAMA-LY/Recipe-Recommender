
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:path_provider/path_provider.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:recipe_recommender_frontend/screens/splash_screen/splash_screen.dart';

import 'api/session.dart';
import 'screens/nav/bottom_nav_screen.dart';

var session = Session("");

String cookieStr = "";
File? cacheFile;

Future<String> getLocalPath() async {
  final directory = await getTemporaryDirectory();
  return directory.path;
}

Future<File> getLocalFile() async {
  final path = await getLocalPath();
  debugPrint(path);
  return File('$path/cookie.txt').create();
}

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  var url = Uri.http(
      "${const String.fromEnvironment("BrainFoodBackendIP", defaultValue: "localhost")}:8080",
      "/home");
  print(url.toString());
  getLocalFile()
      .then((value) => {
            cacheFile = value,
            cookieStr = cacheFile!.readAsStringSync(),
            runApp(const BuildApp())
          })
      .onError((error, stackTrace) => {
            debugPrint(error.toString()),
            debugPrint("Can't get cache file"),
            runApp(const BuildApp())
          });
}

Future<String?> getServerInitResponse() async {
  session.cookie = cookieStr;
  var url = Uri.http(
      "${const String.fromEnvironment("BrainFoodBackendIP", defaultValue: "localhost")}:8080",
      "/home");
  var serverResponse = await http.get(url, headers: {
    "cookie": session.cookie,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "POST, OPTIONS, GET",
    "Access-Control-Allow-Headers":
        "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
  });
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
              debugPrint("IN");
              return const SignInPage();
            }
          } else {
            debugPrint("IN2");
            return const SplashScreenPage();
          }
        },
      ),
    );
  }
}

class BuildApp extends StatelessWidget {
  const BuildApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
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
    );
  }
}

