import 'dart:convert';

import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:http/http.dart' as http;

import '../models/failure.dart';

class GetRecipesAPI {
  Future<List<Recipe>> getRecipes(String path) async {
    var url = Uri.http("localhost:8080", "/$path");
    var response = await http.get(url);

    if (response.statusCode == 200) {
      return Recipe.recipesFromSnapshot(jsonDecode(response.body));
    } else if (response.statusCode == 401) {
      throw Failure(code: 401, message: "fail");
    } else {
      throw Failure(
          code: response.statusCode, message: response.headers.toString());
    }
  }
}



