import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';

import '../models/failure.dart';

class RecipesAPI {
  var cookie;

  RecipesAPI();

  RecipesAPI.fromCookie(var this.cookie);

  Future<List<Recipe>> getRecipes(String path) async {
    var url =
        Uri.https(const String.fromEnvironment("BrainFoodBackendIP"), path);
    var response = await http.get(url, headers: {
      "cookie": session.cookie,
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "POST, OPTIONS, GET",
      "Access-Control-Allow-Headers":
          "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
    });
    debugPrint(response.statusCode.toString());

    if (response.statusCode == 200) {
      return Recipe.shortRecipesFromSnapshot(jsonDecode(response.body));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }

  Future<List<Recipe>> getRecipesWithQuery(
      String path, Map<String, String> query) async {
    var url = Uri.https(
        const String.fromEnvironment("BrainFoodBackendIP"), path, query);
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
      return Recipe.shortRecipesFromSnapshot(
          jsonDecode(response.body.toString()));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }
}
