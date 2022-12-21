import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/api/api_constants.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/ingredient.dart';

import '../models/failure.dart';

class IngredientsAPI {
  String cookie;

  IngredientsAPI.fromCookie(var this.cookie);

  Future<List<String>> getIngredients() async {
    var url = Uri.https(APIConstants.baseUrl, APIConstants.ingredientsEndPoint);
    var response = await http.get(url, headers: APIConstants.headerCORS(session.cookie));
    debugPrint(response.statusCode.toString());

    if (response.statusCode == 200) {
      return Ingredient.ingredientsFromSnapshot(jsonDecode(response.body));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }
}

