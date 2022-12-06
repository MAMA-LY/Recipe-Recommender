import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/home_recipes_api.dart';
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
  List<Recipe> _recipes = [
    //Recipe(name: "name", photo: "photo", ID: "ID"),
    Recipe(name: "name", photo: "photo", ID: "ID"),
    Recipe(name: "tutu", photo: "https://picsum.photos/250?image=9", ID: "ID"),
    //Recipe(name: "name", photo: "photo", ID: "ID"),
  ];
  bool _isLoading = false;
  final searchAPI = GetRecipesAPI();

  @override
  void initState() {
    super.initState();
    getRecipes();
  }

  Future<void> getRecipes() async {
    _recipes = await searchAPI.getRecipes("search");
    setState(() {
      _isLoading = false;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
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
        body: _isLoading
            ? const Center(
                child: CircularProgressIndicator(
                color: Constants.primaryColor,
              ))
            : Column(children: <Widget>[
                Expanded(
                    child: ListView.builder(
                  itemCount: _recipes.length,
                  itemBuilder: (context, index) {
                    return RecipeCard(
                        title: _recipes[index].name,
                        thumbnailUrl: _recipes[index].photo);
                  },
                ))
              ]));
  }

  Future<void> _showSearch() async {
    await showSearch(
      context: context,
      delegate: TheSearch(),
      query: "any query",
    );
  }
}

class TheSearch extends SearchDelegate<String> {
  final suggestions1 = ["https://www.google.com"];

  @override
  String get searchFieldLabel => "Enter a web address";

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
    GetRecipesAPI api = GetRecipesAPI.fromCookie(session.cookie);
    List<Recipe>? _recipes = [];
    debugPrint("I'm here");
    return FutureBuilder<List<Recipe>>(
      initialData: [], // You can set initial data or check snapshot.hasData in the builder
      future: api.getRecipesWithQuery(
          "search/sentence", {"sentence": query}), // Run check for a single queryRow
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          debugPrint("SNAPSHOT: " + snapshot.data.toString());
          // snapshot.data is what being return from the above async function
          // True: Return your UI element with Name and Avatar here for number in Contacts
          return Column(children: <Widget>[
            Expanded(
                child: ListView.builder(
              itemCount: snapshot.data?.length,
              itemBuilder: (context, index) {
                return RecipeCard(
                    title: snapshot.data![index].name,
                    thumbnailUrl: snapshot.data![index].photo);
              },
            ))
          ]);
        } else {
          return Column();
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
}
