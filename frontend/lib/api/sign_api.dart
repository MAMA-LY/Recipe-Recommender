import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/api/api_constants.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:flutter/material.dart';

class SignAPI {
  static Future<String?> signup(
      String username, String password, String email) async {
    var url = Uri.http(APIConstants.baseUrl, APIConstants.signupEndPoint);
    var credentials = {
      "username": username,
      "password": password,
      "email": email
    };
    var response = await http.post(url,
        body: credentials, headers: APIConstants.headerCORS(""));
    return response.body;
  }

  static Future<String?> signin(String username, String password) async {
    var url = Uri.http(APIConstants.baseUrl, APIConstants.signinEndPoint);
    var response = await http.post(url,
        body: {"username": username, "password": password},
        headers: APIConstants.headerCORS(""));
    debugPrint(response.statusCode.toString());
    var cookie = response.headers['set-cookie'];
    var responseLocation = response.headers['location'];
    if (responseLocation == "http://192.168.1.101:8080/signin?error") {
      return "wrong credentials";
    }
    if (responseLocation == "http://192.168.1.101:8080/home" &&
        cookie != null) {
      session.cookie = cookie;
      if (cacheFile != null) {
        cacheFile = await cacheFile!.writeAsString(session.cookie);
      }
      var urlHome = Uri.http(APIConstants.baseUrl, APIConstants.homeEndPoint);

      var responseHome =
          await http.post(urlHome, headers: APIConstants.headerCORS(cookie));
      return "right credentials";
    }
    return null;
  }

  static Future<String?> forgetPassword(String email) async {
    var url = Uri.http(APIConstants.baseUrl, APIConstants.forgetPasswordEndPoint);
    var response = await http.post(url,
        body: {"email": email}, headers: APIConstants.headerCORS(""));
    return response.body;
  }

  static Future<String?> resetPassword(String tk) async {
    var url = Uri.http(APIConstants.baseUrl, APIConstants.resetPassword, {"tk" : tk});
    var response = await http.get(url,
        headers: APIConstants.headerCORS(""));
    return response.body;
  }

  static Future<String?> changePassword(String password, String tk) async {
    var url = Uri.http(APIConstants.baseUrl, APIConstants.changePassword);
    var response = await http.post(url,
        body: {"password": password, "tk": tk},
        headers: APIConstants.headerCORS(""));
    return response.body;
  }
}
