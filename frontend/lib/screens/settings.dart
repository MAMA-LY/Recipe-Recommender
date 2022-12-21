import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';

import '../api/api_constants.dart';
import '../constants.dart';
import '../main.dart';

class SettingsPage extends StatelessWidget {
  static String routeName = "/settings";

  const SettingsPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        onPressed: () async {
          var url = Uri.https(APIConstants.baseUrl, APIConstants.signoutEndPoint);
          debugPrint(session.cookie);
          var response =
          await http.post(url, headers: {"cookie": session.cookie});
          debugPrint(response.statusCode.toString());
          Navigator.of(context, rootNavigator: true).pushReplacement(
              MaterialPageRoute(builder: (context) =>  const SignInPage(initResp: "",)));
          cacheFile!.delete();
        },
        child: const Text(
          "Sign out",
          style: TextStyle(
            color: Constants.secondaryColor,
            fontStyle: FontStyle.italic,
            fontFamily: "Roboto",
            fontWeight: FontWeight.bold,
            fontSize: 18,
          ),
        ));
  }
}
