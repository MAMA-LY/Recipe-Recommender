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
import 'api/api_constants.dart';
import 'api/recipes_api.dart';
import 'api/session.dart';
import 'models/recipe.dart';
import 'screens/page_view_controller.dart';
import 'screens/recipe_page/recipe_page.dart';

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

// Future<void> initUniLinks() async {
//   try {
//     final initialUri = await getInitialUri();
//     debugPrint("init link");
//     if (initialUri != null) {
//       List<String?> path = initialUri.pathSegments;
//       debugPrint(path.toString());
//       if (path[0] == "resetPassword") {
//         String? tk = initialUri.queryParameters['tk'];
//         if (tk != null) {
//           var response = await SignAPI.resetPassword(tk);
//           debugPrint(response);
//           if (response == "InvalidToken") {
//             runApp(const BuildApp(
//                 widget: SignInPage(initResp: "Cannot reset password")));
//           } else if (response == "TokenVerified") {
//             runApp(BuildApp(widget: ChangePasswordPage(tk: tk)));
//           }
//         } else {
//           runApp(const BuildApp(
//               widget: SignInPage(initResp: "Cannot reset password")));
//         }
//       } else if (path[0] == "share") {
//         if (Session.login) {
//           String? id = initialUri.queryParameters['id'];
//           if (id != null) {
//             debugPrint(id);
//             RecipesAPI api = RecipesAPI.fromCookie(session.cookie);
//             Recipe response = await api.getRecipeByID(id.trim());
//             runApp(BuildApp(widget:RecipePage(recipe: response, inFavorites: false)));
//           }
//         } else {
//           runApp(const BuildApp(widget: SignInPage(initResp: "")));
//         }
//       } else {
//         runApp(const BuildApp(widget: SignInPage(initResp: "")));
//       }
//     }
//     debugPrint(initialUri.toString());
//     debugPrint("bodnod2");
//     _sub = uriLinkStream.listen((Uri? uri) async {
//       debugPrint("bodnod2");
//       if (uri != null) {
//         List<String?> path = uri.pathSegments;
//         debugPrint(path.toString());
//         debugPrint(uri.toString());

//         if (path[0] == "resetPassword") {
//           String? tk = uri.queryParameters['tk'];
//           if (tk != null) {
//             var response = await SignAPI.resetPassword(tk);
//             debugPrint("reso");
//             debugPrint(response);
//             if (response == "InvalidToken") {
//               runApp(const BuildApp(
//                   widget: SignInPage(initResp: "Cannot reset password")));
//             } else if (response == "TokenVerified") {
//               debugPrint("lolxd");
//               runApp(BuildApp(widget: ChangePasswordPage(tk: tk)));
//             }
//           } else {
//             runApp(const BuildApp(
//                 widget: SignInPage(initResp: "Cannot reset password")));
//           }
//         } else if (path[0] == "share") {
//           if (Session.login) {
//             String? id = uri.queryParameters['id'];
//             if (id != null) {
//               debugPrint(id);
//               RecipesAPI api = RecipesAPI.fromCookie(session.cookie);
//               Recipe response = await api.getRecipeByID(id.trim());
//               runApp(BuildApp(widget:RecipePage(recipe: response, inFavorites: false)));
//             }
//           } else {
//             runApp(const BuildApp(widget: SignInPage(initResp: "")));
//           }
//         } else {
//           runApp(const BuildApp(widget: SignInPage(initResp: "")));
//         }
//       }
//       debugPrint("run");
//     }, onError: (err) {
//       debugPrint(err);
//     });
//   } on PlatformException {
//     debugPrint("eror");
//   }
// }
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
  // initUniLinks();
}

Future<String?> getServerInitResponse() async {
  session.cookie = cookieStr;
  var url = Uri.https(APIConstants.baseUrl, APIConstants.homeEndPoint);
  var serverResponse =
      await http.get(url, headers: APIConstants.headerCORS(session.cookie));
  debugPrint(serverResponse.body);
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
      backgroundColor: Theme.of(context).secondaryHeaderColor,
      body: FutureBuilder(
        future: getServerInitResponse(),
        initialData: "",
        builder: (builder, snapshot) {
          if (snapshot.connectionState == ConnectionState.done) {
            String response = snapshot.data!;
            if (response == "UserInfo") {
              Session.login = true;
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
class BuildApp extends StatefulWidget {
    final Widget widget;
    const BuildApp({super.key, required this.widget});

  @override
  BuildAppState createState() => BuildAppState();
  static BuildAppState? of(BuildContext context) => context.findAncestorStateOfType<BuildAppState>();
}
class BuildAppState extends State<BuildApp> {
  late ThemeMode _themeMode = ThemeMode.system;
  ThemeMode getTheme(){
    return _themeMode;
  }
  void changeTheme(ThemeMode themeMode) {
    setState(() {
      _themeMode = themeMode;
    });
  }
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      themeMode: _themeMode,
      theme: ThemeData(
        brightness: Brightness.light,
        dividerColor: Colors.transparent,
        fontFamily: 'Satoshi',
        primarySwatch: Colors.orange,
        primaryColor: Constants.primaryColor,
        secondaryHeaderColor: Constants.secondaryColor,
        focusColor: Constants.fourthColor,
        textTheme: const TextTheme(
          headline1: TextStyle(
            fontFamily: 'Telma',
            fontSize: 24,
            fontWeight: FontWeight.bold,
            color: Constants.primaryColor,
          ),
        ),
      ),
      darkTheme: ThemeData(
        brightness: Brightness.dark,
        dividerColor: Colors.transparent,
        fontFamily: 'Satoshi',
        primarySwatch: Colors.orange,
        primaryColor: Constants.primaryColor,
        secondaryHeaderColor: Constants.fourthColor,
        focusColor: Constants.secondaryColor,
        textTheme: const TextTheme(
          headline1: TextStyle(
            fontFamily: 'Telma',
            fontSize: 24,
            fontWeight: FontWeight.bold,
            color: Constants.primaryColor,
          ),
        ),
      ),
      home: widget.widget,
    );
  }
}
