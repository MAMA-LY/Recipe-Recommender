
import 'dart:convert';
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:http/http.dart' as http;

import '../models/failure.dart';

class GetRecipesAPI {
  var cookie;

  GetRecipesAPI() {}

  GetRecipesAPI.fromCookie(var this.cookie);

  Future<List<Recipe>> getRecipes(String path) async {

    var url = Uri.http(
        "${const String.fromEnvironment("BrainFoodBackendIP")}:8080", "/$path");
    var response = await http.get(url, headers: {
      "cookie": session.cookie,
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "POST, OPTIONS, GET",
      "Access-Control-Allow-Headers":
      "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
    });
    debugPrint(response.statusCode.toString());

    if (response.statusCode == 200) {
      return Recipe.recipesFromSnapshot(jsonDecode(response.body));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }

  Future<List<Recipe>> getRecipesWithQuery(String path, Map<String, String> query) async {

    var url = Uri.http(
        "${const String.fromEnvironment("BrainFoodBackendIP")}:8080", "/$path", query);
    var response = await http.get(url, headers: {
      "cookie": session.cookie,
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "POST, OPTIONS, GET",
      "Access-Control-Allow-Headers":
      "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
    });
    debugPrint(response.statusCode.toString());
    debugPrint(response.body.toString());
    if (response.statusCode == 200) {
      return Recipe.recipesFromSnapshot(jsonDecode(response.body.toString()));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }
}






