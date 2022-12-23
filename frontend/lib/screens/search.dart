import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/recipes_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/widgets/recipe_card.dart';

import '../../main.dart';

class SearchPage extends StatefulWidget {
  static String routeName = "/search";
  const SearchPage({super.key});

  @override
  State<SearchPage> createState() => _SearchPageState();
}

class _SearchPageState extends State<SearchPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
<<<<<<< HEAD
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
              icon: const Icon(Icons.search),
              onPressed: _showSearch,
            ),
          ],
        ),
=======
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
            icon: const Icon(Icons.search),
            onPressed: _showSearch,
          ),
        ],
      ),
>>>>>>> main
    );
  }

  Future<void> _showSearch() async {
    await showSearch(
      context: context,
      delegate: TheSearch(),
      query: "",
    );
  }
}

class TheSearch extends SearchDelegate<String> {
  final suggestions1 = ["egg"];

  @override
  String get searchFieldLabel => "Enter Ingredient";

  @override
  List<Widget> buildActions(BuildContext context) {
    return [
      IconButton(
        icon: const Icon(Icons.clear),
        onPressed: () {
          query = "";
        },
      )
    ];
  }

  @override
  Widget buildLeading(BuildContext context) {
    return IconButton(
      icon: AnimatedIcon(
        icon: AnimatedIcons.menu_arrow,
        progress: transitionAnimation,
      ),
      onPressed: () {
        close(context, "");
      },
    );
  }

  @override
  Widget buildResults(BuildContext context) {
    RecipesAPI api = RecipesAPI.fromCookie(session.cookie);
    debugPrint("I'm here");
    return FutureBuilder<List<Recipe>>(
<<<<<<< HEAD
      future: api.getRecipesWithQuery(
          "search/sentence", {"sentence": query}),
=======
      future: api.getRecipesWithQuery("search/sentence", {"sentence": query}),
>>>>>>> main
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.done) {
          debugPrint("SNAPSHOT: ${snapshot.data}");

          return Column(children: <Widget>[
            Expanded(
                child: ListView.builder(
<<<<<<< HEAD
                  itemCount: snapshot.data?.length,
                  itemBuilder: (context, index) {
                    return RecipeCard(
                        id: snapshot.data![index].id,
                        name: snapshot.data![index].name,
                        thumbnailUrl: snapshot.data![index].image);
                  },
                ))
=======
              itemCount: snapshot.data?.length,
              itemBuilder: (context, index) {
                return RecipeCard(
                    id: snapshot.data![index].id,
                    name: snapshot.data![index].name,
                    thumbnailUrl: snapshot.data![index].image);
              },
            ))
>>>>>>> main
          ]);
        } else {
          return const Center(
              child: CircularProgressIndicator(
<<<<<<< HEAD
                color: Constants.primaryColor,
              )
          );
=======
            color: Constants.primaryColor,
          ));
>>>>>>> main
        }
      },
    );
  }

  @override
  Widget buildSuggestions(BuildContext context) {
    final suggestions = query.isEmpty ? suggestions1 : [];
    return ListView.builder(
      itemCount: suggestions.length,
      itemBuilder: (content, index) => ListTile(
          leading: const Icon(Icons.arrow_left),
          title: Text(suggestions[index])),
    );
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> main
