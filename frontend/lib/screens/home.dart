import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/widgets/recipe_card.dart';

import '../api/api_constants.dart';
import '../api/recipes_api.dart';
import '../main.dart';

class HomePage extends StatefulWidget {
  static String routeName = "/home";

  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  RecipesAPI api = RecipesAPI.fromCookie(session.cookie);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
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
  }
}
