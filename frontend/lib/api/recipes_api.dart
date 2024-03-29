import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/api/api_constants.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';

import '../models/failure.dart';

class RecipesAPI {
  String cookie;

  RecipesAPI.fromCookie(var this.cookie);

  Future<Recipe> getRecipeByID(String id) async {
    var url = Uri.https(
        APIConstants.baseUrl, APIConstants.recipeEndPoint, {"id": id});
    var response =
        await http.get(url, headers: APIConstants.headerCORS(session.cookie));
    debugPrint(response.statusCode.toString());
    debugPrint(response.body);
    if (response.statusCode == 200) {
      return Recipe.recipeFromJson(jsonDecode(response.body));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }

  Future<Recipe> getRecipeShareByID(String id) async {
    var url = Uri.https(
        APIConstants.baseUrl, APIConstants.shareRecipeEndPoint, {"id": id});
        debugPrint(url.toString());
    var response = await http.get(url);
    debugPrint(response.statusCode.toString());
    debugPrint(response.body);
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
    var response =
        await http.get(url, headers: APIConstants.headerCORS(session.cookie));
    debugPrint(response.statusCode.toString());
    debugPrint(response.body.toString());
    if (response.statusCode == 200) {
      debugPrint(response.body.toString());
      return Recipe.shortRecipesFromSnapshot(
          jsonDecode(response.body.toString()));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }

  Future<Recipe> rateRecipe(String id, double rate) async {
    var url = Uri.https(APIConstants.baseUrl, APIConstants.rateRecipe,
        {"recipeID": id, "rate": rate.toString()});
    var response =
        await http.post(url, headers: APIConstants.headerCORS(session.cookie));
    if (response.statusCode == 200) {
      return Recipe.recipeFromJson(jsonDecode(response.body));
       } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }
  Future<List<Recipe>> getFavRecipes() async {
    var url =
        Uri.https(APIConstants.baseUrl, APIConstants.getFavRecipeEndPoint);
    var response =
        await http.get(url, headers: APIConstants.headerCORS(session.cookie));

    if (response.statusCode == 200) {
      debugPrint(response.body.toString());
      return Recipe.shortRecipesFromSnapshot(
          jsonDecode(response.body.toString()));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }

  Future<String> addFavRecipe(String id) async {
    var url = Uri.https(
        APIConstants.baseUrl, APIConstants.addFavRecipeEndPoint, {"id": id});
    var response =
        await http.post(url, headers: APIConstants.headerCORS(session.cookie));
    if (response.statusCode == 200) {
      debugPrint(response.body.toString());
      return response.body;
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }

  Future<String> removeFavRecipe(String id) async {
    var url = Uri.https(
        APIConstants.baseUrl, APIConstants.removeFavRecipeEndPoint, {"id": id});
    var response =
        await http.post(url, headers: APIConstants.headerCORS(session.cookie));
    if (response.statusCode == 200) {
      debugPrint(response.body.toString());
      return response.body;
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }
}
