import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/api/api_constants.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';

import '../models/failure.dart';

class RecipesAPI {
<<<<<<< HEAD
  var cookie;

  RecipesAPI();

  RecipesAPI.fromCookie(var this.cookie);

  Future<List<Recipe>> getRecipes(String path) async {
    var url = Uri.https(APIConstants.baseUrl, path);
    var response = await http.get(url, headers: APIConstants.headerCORS(session.cookie));
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
=======
  String cookie;

  RecipesAPI.fromCookie(var this.cookie);

>>>>>>> main
  Future<Recipe> getRecipeByID(String id) async {
    var url = Uri.https(APIConstants.baseUrl, APIConstants.recipeEndPoint, {"id": id});
    var response = await http.get(url, headers: APIConstants.headerCORS(session.cookie));
    debugPrint(response.statusCode.toString());
<<<<<<< HEAD

=======
    debugPrint(response.body);
>>>>>>> main
    if (response.statusCode == 200) {
      return Recipe.recipeFromJson(jsonDecode(response.body));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }

  Future<List<Recipe>> getRecipesWithQuery(
      String path, Map<String, String> query) async {
    var url = Uri.https(APIConstants.baseUrl, path, query);
<<<<<<< HEAD
    var response = await http.get(url, headers: APIConstants.headerCORS(session.cookie));
    debugPrint(response.statusCode.toString());
    debugPrint(response.body.toString());
    if (response.statusCode == 200) {
=======
    var response =
        await http.get(url, headers: APIConstants.headerCORS(session.cookie));
    debugPrint(response.statusCode.toString());
    debugPrint(response.body.toString());
    if (response.statusCode == 200) {
      debugPrint(response.body.toString());
>>>>>>> main
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
<<<<<<< HEAD

=======
>>>>>>> main
