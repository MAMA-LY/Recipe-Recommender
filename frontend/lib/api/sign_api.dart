import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/api/api_constants.dart';
import 'package:recipe_recommender_frontend/main.dart';

class SignAPI {
  static Future<String?> signup(
      String username, String password, String email) async {
    var url = Uri.https(APIConstants.baseUrl, APIConstants.signupEndPoint);
    var credentials = {
      "username": username,
      "password": password,
      "email": email
    };
    var response = await http.post(url, body: credentials, headers: APIConstants.headerCORS(""));
    return response.body;
  }

  static Future<String?> signin(String username, String password) async {
    var url = Uri.https(APIConstants.baseUrl, APIConstants.signinEndPoint);
    var response = await http.post(url, body: {
      "username": username,
      "password": password
    }, headers: APIConstants.headerCORS(""));

    var cookie = response.headers['set-cookie'];
    var responseLocation = response.headers['location'];
    if (responseLocation ==
        "http://${APIConstants.baseUrl + APIConstants.signinEndPoint}?error") {
      return "wrong credentials";
    }
    if (responseLocation ==
            "http://${APIConstants.baseUrl + APIConstants.homeEndPoint}" &&
        cookie != null) {
      session.cookie = cookie;
      if (cacheFile != null) {
        cacheFile = await cacheFile!.writeAsString(session.cookie);
      }
      var urlHome = Uri.https(APIConstants.baseUrl, APIConstants.homeEndPoint);

      var responseHome = await http.post(urlHome, headers: APIConstants.headerCORS(cookie));
      return "right credentials";
    }
    return null;
  }
}
