import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/recipes_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/models/ingredient.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/recipe_page.dart';
<<<<<<< HEAD

=======
>>>>>>> main

class RecipeCard extends StatelessWidget {
  final String id;
  final String name;
  final String thumbnailUrl;
  // ignore: prefer_final_fields
  final Recipe _recipe = Recipe(
<<<<<<< HEAD
          name: "shaksouka",
          image: "https://welcome2jordan.com/wp-content/uploads/2022/09/Shakshuka-Recipe-Welcome2Jordan.jpg",
          id: "32325",
          cuisine: "egypt",
          tags: ["diary", "diet", "breakfast"],
          nutrition: Nutrition(calories: 50, fats: 30, carbs: 25, proteins: 12),
          ingredients: [Ingredient(
=======
      name: "shaksouka",
      image:
          "https://welcome2jordan.com/wp-content/uploads/2022/09/Shakshuka-Recipe-Welcome2Jordan.jpg",
      id: "32325",
      cuisine: "egypt",
      tags: ["diary", "diet", "breakfast"],
      nutrition: Nutrition(calories: 50, fats: 30, carbs: 25, proteins: 12),
      ingredients: [
        Ingredient(
>>>>>>> main
            name: "tomato",
            id: "12222",
            icon: "icon",
            amount: "3 pieces of tomatos",
<<<<<<< HEAD
            nutrition: Nutrition(
              calories: 18, 
              fats: 20, 
              carbs: 9, 
              proteins: 6
            )
          ),Ingredient(
=======
            nutrition:
                Nutrition(calories: 18, fats: 20, carbs: 9, proteins: 6)),
        Ingredient(
>>>>>>> main
            name: "egg",
            id: "12222",
            icon: "icon",
            amount: "3 eggs",
<<<<<<< HEAD
            nutrition: Nutrition(
              calories: 18, 
              fats: 20, 
              carbs: 9, 
              proteins: 6
            )
          )]
        );


=======
            nutrition: Nutrition(calories: 18, fats: 20, carbs: 9, proteins: 6))
      ]);

>>>>>>> main
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
<<<<<<< HEAD
          context,
          MaterialPageRoute(builder: (context) =>   RecipePage(recipe: apiRecipe, inFavorites: false)),
=======
      context,
      MaterialPageRoute(
          builder: (context) =>
              RecipePage(recipe: apiRecipe, inFavorites: false)),
>>>>>>> main
    );
  }

  @override
  Widget build(BuildContext context) {
    return TextButton(
<<<<<<< HEAD
=======
      onPressed: () => _getRecipeByID(context, id),
>>>>>>> main
      child: Container(
        margin: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
        width: MediaQuery.of(context).size.width,
        height: MediaQuery.of(context).size.height / 4,
        decoration: BoxDecoration(
          color: Colors.black,
          borderRadius: BorderRadius.circular(15),
          boxShadow: [
            BoxShadow(
              color: Colors.black.withOpacity(0.6),
              offset: const Offset(
                0.0,
                10.0,
              ),
              blurRadius: 10.0,
              spreadRadius: -6.0,
            ),
          ],
          image: DecorationImage(
            colorFilter: ColorFilter.mode(
              Colors.black.withOpacity(0.20),
              BlendMode.multiply,
            ),
            image: Image.network(thumbnailUrl,
                    height: MediaQuery.of(context).size.height)
                .image,
            fit: BoxFit.cover,
          ),
        ),
        child: Stack(
          children: [
            Align(
              alignment: Alignment.center,
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 5.0),
                child: Text(
                  name,
                  style: const TextStyle(
                    fontSize: 24,
                    color: Constants.secondaryColor,
                    fontFamily: "Roboto",
                    fontWeight: FontWeight.bold,
                  ),
                  overflow: TextOverflow.ellipsis,
                  maxLines: 2,
                  textAlign: TextAlign.center,
                ),
              ),
            ),
          ],
        ),
      ),
<<<<<<< HEAD
      onPressed: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) =>   RecipePage(recipe: _recipe, inFavorites: false)),
        );
      },
=======
>>>>>>> main
    );
  }
}
