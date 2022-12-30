import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/widgets/recipe_card.dart';

import '../api/api_constants.dart';
import '../api/recipes_api.dart';
import '../main.dart';

class FavoritesPage extends StatefulWidget {
  static String routeName = "/favorites";

  const FavoritesPage({super.key});

  @override
  State<FavoritesPage> createState() => _FavoritesPageState();
}

class _FavoritesPageState extends State<FavoritesPage> {

  RecipesAPI api = RecipesAPI.fromCookie(session.cookie);

  final bool _isLoading = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Theme.of(context).secondaryHeaderColor,
        appBar: AppBar(
          elevation: 0,
          backgroundColor: Theme.of(context).secondaryHeaderColor,
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
        future: api.getFavRecipes(),
        builder: (context, snapshot) {
          debugPrint("SNAPSHOT1: ${snapshot.data}");
          if (snapshot.connectionState == ConnectionState.done) {
            debugPrint("SNAPSHOT2: ${snapshot.data}");

            return Column(
              mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: <Widget>[
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
  }
}
