import 'dart:developer';
import 'dart:io';
import 'dart:math';

import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/api/api_constants.dart';
import 'package:recipe_recommender_frontend/main.dart';


class SignAPI {
static Future<String?> signup(String username, String password, String email) async{
    var url = Uri.https("${ApiConstants.baseUrl}", "${ApiConstants.signupEndPoint}");
    var creds = {
      "username": username,
      "password": password,
      "email": email
    };
    var response = await http.post(url, body: creds, headers: {
                        "Access-Control-Allow-Origin": "*",
                        "Access-Control-Allow-Methods":
                        "POST, OPTIONS, GET",
                        "Access-Control-Allow-Headers":
                        "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
                    });
    return response.body;
  }
  
  static Future<String?> signin(String username, String password) async {
      var url = Uri.https("${ApiConstants.baseUrl}", "${ApiConstants.signinEndPoint}");
      var response = await http.post(url, body: {
                            "username": username,
                            "password": password
                          }, headers: {
                            "Access-Control-Allow-Origin": "*",
                            "Access-Control-Allow-Methods":
                                "POST, OPTIONS, GET",
                            "Access-Control-Allow-Headers":
                                "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
                          });
      
      
      var cookie = response.headers['set-cookie'];
      var responseLocation = response.headers['location'];
      if (responseLocation == "https://${ApiConstants.baseUrl+ApiConstants.signinEndPoint}?error") {
        return "wrong credintials";
      }
      if (responseLocation == "https://${ApiConstants.baseUrl+ApiConstants.homeEndPoint}" && cookie != null) {
        session.cookie = cookie;
        if (cacheFile != null) {
          cacheFile = await cacheFile!.writeAsString(session.cookie);
        }
        var urlHome = Uri.https(ApiConstants.baseUrl, ApiConstants.homeEndPoint);
        var responseHome = await http.post(urlHome, headers: {
          "cookie": cookie,
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods":
          "POST, OPTIONS, GET",
          "Access-Control-Allow-Headers":
          "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
        });
        return "right credintials";
      } 
    return null;
  }
}