import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/models/ingredient.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/recipe_%20page/recipe_page.dart';

class RecipeCard extends StatelessWidget {
  final String id;
  final String name;
  final String thumbnailUrl;
  // ignore: prefer_final_fields
  final Recipe _recipe = Recipe(
          name: "shaksouka",
          image: "https://welcome2jordan.com/wp-content/uploads/2022/09/Shakshuka-Recipe-Welcome2Jordan.jpg",
          id: "32325",
          cuisine: "egypt",
          tags: ["diary", "diet", "breakfast"],
          nutrition: Nutrition(calories: 50, fats: 30, carbs: 25, proteins: 12),
          ingredients: [Ingredient(
            name: "tomato",
            id: "12222",
            icon: "icon",
            amount: "3 pieces of tomatos",
            nutrition: Nutrition(
              calories: 18, 
              fats: 20, 
              carbs: 9, 
              proteins: 6
            )
          ),Ingredient(
            name: "egg",
            id: "12222",
            icon: "icon",
            amount: "3 eggs",
            nutrition: Nutrition(
              calories: 18, 
              fats: 20, 
              carbs: 9, 
              proteins: 6
            )
          )]
        );

  RecipeCard({
    super.key,
    required this.id,
    required this.name,
    required this.thumbnailUrl,
  });

  @override
  Widget build(BuildContext context) {
    return TextButton(
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
      onPressed: () {
        Navigator.push(
          context,
          
          MaterialPageRoute(builder: (context) =>  RecipePage(recipe: _recipe, inFavorites: false)),
        );
      },
    );
  }
}
