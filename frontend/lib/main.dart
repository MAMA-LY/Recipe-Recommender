import 'dart:io';
import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:http/http.dart' as http;
import 'package:path_provider/path_provider.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/screens/sign/changePassword.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:recipe_recommender_frontend/screens/splash_screen.dart';
import 'package:uni_links/uni_links.dart';
import 'api/api_constants.dart';
import 'api/session.dart';
import 'screens/page_view_controller.dart';

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

Widget startWidget = const MyApp();
StreamSubscription? _sub;

Future<void> initUniLinks() async {
  try {
    final initialUri = await getInitialUri();
    debugPrint("init link");
    if (initialUri != null) {
      List<String?> path = initialUri.pathSegments;
      debugPrint(path.toString());
      if (path[0] == "resetPassword") {
        String? tk = initialUri.queryParameters['tk'];
        if (tk != null) {
          var response = await SignAPI.resetPassword(tk);
          debugPrint(response);
          if (response == "InvalidToken") {
            runApp(const BuildApp(
                widget: SignInPage(initResp: "Cannot reset password")));
          } else if (response == "TokenVerified") {
            runApp(BuildApp(widget: changePasswordPage(tk: tk)));
          }
        } else {
          runApp(const BuildApp(
              widget: SignInPage(initResp: "Cannot reset password")));
        }
      } else {
        runApp(const BuildApp(widget: SignInPage(initResp: "")));
      }
    }
    debugPrint(initialUri.toString());
    debugPrint("bodnod2");
    _sub = uriLinkStream.listen((Uri? uri) async {
      debugPrint("bodnod2");
      if (uri != null) {
        List<String?> path = uri.pathSegments;
        debugPrint(path.toString());
        debugPrint(uri.toString());

        if (path[0] == "resetPassword") {
          String? tk = uri.queryParameters['tk'];
          if (tk != null) {
            var response = await SignAPI.resetPassword(tk);
            debugPrint("reso");
            debugPrint(response);
            if (response == "InvalidToken") {
              runApp(const BuildApp(
                  widget: SignInPage(initResp: "Cannot reset password")));
            } else if (response == "TokenVerified") {
              debugPrint("lolxd");
              runApp(BuildApp(widget: changePasswordPage(tk: tk)));
            }
          } else {
            runApp(const BuildApp(
                widget: SignInPage(initResp: "Cannot reset password")));
          }
        } else {
          runApp(const BuildApp(widget: SignInPage(initResp: "")));
        }
      }
      debugPrint("run");
    }, onError: (err) {
      debugPrint(err);
    });
  } on PlatformException {
    debugPrint("eror");
  }
}
// Use the uri and warn the user, if it is not correct,
// but keep in mind it could be `null`.
// ... other exception handling like PlatformException

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  var url = Uri.https(APIConstants.baseUrl, APIConstants.homeEndPoint);
  debugPrint(url.toString());
  getLocalFile()
      .then((value) => {
            cacheFile = value,
            cookieStr = cacheFile!.readAsStringSync(),
            runApp(const BuildApp(widget: MyApp()))
          })
      .onError((error, stackTrace) => {
            debugPrint(error.toString()),
            debugPrint("Can't get cache file"),
            runApp(const BuildApp(widget: MyApp()))
          });
  initUniLinks();
}

Future<String?> getServerInitResponse() async {
  session.cookie = cookieStr;
  var url = Uri.https(APIConstants.baseUrl, APIConstants.homeEndPoint);
  var serverResponse =
      await http.get(url, headers: APIConstants.headerCORS(session.cookie));
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
          if (snapshot.connectionState == ConnectionState.done) {
            String response = snapshot.data!;
            if (response == "UserInfo") {
              return const PageViewController();
            } else {
              debugPrint("IN");
              return const SignInPage(
                initResp: "",
              );
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
  final Widget widget;
  const BuildApp({Key? key, required this.widget}) : super(key: key);
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
      home: widget,
    );
  }
}
