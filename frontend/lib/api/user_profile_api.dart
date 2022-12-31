import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/api/api_constants.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/user_profile.dart';

import '../models/failure.dart';
class UserProfileAPI {
  String cookie;

  UserProfileAPI.fromCookie(var this.cookie);

  Future<UserProfile> getUserProfile() async {
    var url = Uri.http(APIConstants.baseUrl, APIConstants.userProfileEndPoint);
    var response = await http.get(
        url, headers: APIConstants.headerCORS(session.cookie));
    if (response.statusCode == 200) {
      return UserProfile.fromJson(jsonDecode(response.body));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }
}