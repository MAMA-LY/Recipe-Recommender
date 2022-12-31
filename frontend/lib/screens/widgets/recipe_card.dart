import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/recipes_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/ingredient.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/recipe_page.dart';

class RecipeCard extends StatelessWidget {
  final String id;
  final String name;
  final String thumbnailUrl;

  // ignore: prefer_final_fields
  final Recipe _recipe = Recipe(
      name: "shaksouka",
      image:
          "https://welcome2jordan.com/wp-content/uploads/2022/09/Shakshuka-Recipe-Welcome2Jordan.jpg",
      id: "32325",
      cuisine: "egypt",
      tags: ["diary", "diet", "breakfast"],
      nutrition: Nutrition(calories: 50, fats: 30, carbs: 25, proteins: 12),
      ingredients: [
        Ingredient(
            name: "tomato",
            id: "12222",
            icon: "icon",
            amount: "3 pieces of tomatos",
            nutrition:
                Nutrition(calories: 18, fats: 20, carbs: 9, proteins: 6)),
        Ingredient(
            name: "egg",
            id: "12222",
            icon: "icon",
            amount: "3 eggs",
            nutrition: Nutrition(calories: 18, fats: 20, carbs: 9, proteins: 6)),
      ], favourite: false);

  RecipeCard({
    super.key,
    required this.id,
    required this.name,
    required this.thumbnailUrl,
  });

  Future<void> _getRecipeByID(BuildContext context, String id) async {
    RecipesAPI api = RecipesAPI.fromCookie(session.cookie);
    
    Recipe apiRecipe = await api.getRecipeByID(id);
    // ignore: use_build_context_synchronously
    Navigator.push(
      context,
      MaterialPageRoute(
          builder: (context) =>
              RecipePage(recipe: apiRecipe, inFavorites: false, share: false,)),
    );
  }

  @override
  Widget build(BuildContext context) {
    return TextButton(
      onPressed: () => _getRecipeByID(context, id),
      child: Card(
        elevation: 2,
        clipBehavior: Clip.antiAlias,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(25),
        ),
        child: Column(
          children: [
            Stack(
              alignment: Alignment.bottomLeft,
              children: [
                ShaderMask(
                  blendMode: BlendMode.multiply,
                  shaderCallback: (bounds) =>
                      LinearGradient(
                          begin: Alignment.bottomCenter,
                          end: Alignment.topCenter,
                          colors: [Colors.black, Colors.white.withOpacity(0.0)])
                          .createShader(bounds),
                  child: Image.network(
                    thumbnailUrl,
                    fit: BoxFit.fitHeight,
                    height: MediaQuery.of(context).size.height * 0.4,
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.fromLTRB(0, 10, 0, 10),
                  child: Column(
                    children: [
                      Align(
                        alignment: Alignment.center,
                        child: Text(
                          name,
                          style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontFamily: "Roboto",
                            fontSize: 18,
                            color: Constants.secondaryColor,
                          ),
                          textAlign: TextAlign.center,
                        ),
                      ),
                      const SizedBox(height: 13),
                      const Text(
                        "Cooked in 45 Minutes",
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                          fontFamily: "Roboto",
                          fontSize: 18,
                          color: Constants.primaryColor,
                        ),
                        textAlign: TextAlign.center,
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
