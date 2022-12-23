import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/widgets/recipe_card.dart';

<<<<<<< HEAD
<<<<<<<< HEAD:frontend/lib/screens/home.dart
=======
import '../api/api_constants.dart';
import '../api/recipes_api.dart';
import '../main.dart';

>>>>>>> main
class HomePage extends StatefulWidget {
  static String routeName = "/home";

  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
<<<<<<< HEAD
========
class FavoritesPage extends StatefulWidget {
  static String routeName = "/favorites";

  const FavoritesPage({super.key});

  @override
  State<FavoritesPage> createState() => _FavoritesPageState();
}

class _FavoritesPageState extends State<FavoritesPage> {
>>>>>>>> main:frontend/lib/screens/favorites.dart
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
=======
  RecipesAPI api = RecipesAPI.fromCookie(session.cookie);
>>>>>>> main

  @override
  Widget build(BuildContext context) {
    return Scaffold(
<<<<<<< HEAD
        backgroundColor: Constants.secondaryColor,
        appBar: AppBar(
<<<<<<<< HEAD:frontend/lib/screens/home.dart
========
          elevation: 0,
>>>>>>>> main:frontend/lib/screens/favorites.dart
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
=======
      backgroundColor: Constants.secondaryColor,
      appBar: AppBar(
        elevation: 0,
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
      body: FutureBuilder<List<Recipe>>(
        future: api.getRecipesWithQuery(
            APIConstants.homeRecipesEndPoint, {"number": "5"}),
        builder: (context, snapshot) {
          debugPrint("SNAPSHOT1: ${snapshot.data}");
          if (snapshot.connectionState == ConnectionState.done) {
            debugPrint("SNAPSHOT2: ${snapshot.data}");

            return Column(children: <Widget>[
              Expanded(
                  child: ListView.builder(
                itemCount: snapshot.data?.length,
                itemBuilder: (context, index) {
                  debugPrint("SNAPSHOT: ${snapshot.data![index]}");
                  return RecipeCard(
                      id: snapshot.data![index].id,
                      name: snapshot.data![index].name,
                      thumbnailUrl: snapshot.data![index].image);
                },
              ))
            ]);
          } else {
            return const Center(
                child: CircularProgressIndicator(
              color: Constants.primaryColor,
            ));
          }
        },
      ),
    );
>>>>>>> main
  }
}
