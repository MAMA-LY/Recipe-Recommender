import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/widgets/recipe_card.dart';

class HomePage extends StatefulWidget {
  static String routeName = "/home";

  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final List<Recipe> _recipes = [
    Recipe(
        name: "name",
        image: "https://spoonacular.com/recipeImages/634237-556x370.jpg",
        id: "ID"),
    Recipe(
        name: "name",
        image: "https://spoonacular.com/recipeImages/634237-556x370.jpg",
        id: "ID"),
    Recipe(
        name: "name",
        image: "https://spoonacular.com/recipeImages/634237-556x370.jpg",
        id: "ID"),
    Recipe(
        name: "name",
        image: "https://spoonacular.com/recipeImages/634237-556x370.jpg",
        id: "ID"),
  ];
  
  final bool _isLoading = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Constants.secondaryColor,
        appBar: AppBar(
          backgroundColor: Constants.secondaryColor,
          title: Text(
            "ورقة وقلم",
            style: TextStyle(
                fontFamily: "Arslan",
                fontSize: 30,
                foreground: Paint()
                  ..color = Constants.primaryColor
                  ..strokeWidth = 10),
          ),
          actions: [
            IconButton(
              onPressed: () {
                // TODO Navigate to nutrition page
              },
              icon: const Icon(
                Icons.analytics_outlined,
                color: Constants.primaryColor,
              ),
            ),
          ],
        ),
        body: _isLoading
            ? const Center(
                child: CircularProgressIndicator(
                color: Constants.primaryColor,
              ))
            : ListView.builder(
                itemCount: _recipes.length,
                itemBuilder: (context, index) {
                  return RecipeCard(
                      id: _recipes[index].id,
                      name: _recipes[index].name,
                      thumbnailUrl: _recipes[index].image);
                },
              ));
  }
}
