import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../../../api/api_constants.dart';
import '../../../api/recipes_api.dart';
import '../../../constants.dart';
import '../../../main.dart';
import '../../../models/recipe.dart';
import '../../widgets/recipe_card.dart';

class SearchResult extends StatefulWidget {
  final List<String> selectedIngredients;
  final List<String> selectedTags;

  const SearchResult({
    Key? key,
    required this.selectedIngredients,
    required this.selectedTags,
  }) : super(key: key);

  @override
  State<SearchResult> createState() => _SearchResultState();
}

class _SearchResultState extends State<SearchResult> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Constants.secondaryColor,
      appBar: AppBar(
        backgroundColor: Constants.secondaryColor,
        elevation: 0,
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
      body: buildResults(context),
    );
  }

  Widget buildResults(BuildContext context) {
    RecipesAPI api = RecipesAPI.fromCookie(session.cookie);

    Map<String, String> query = {
      for (var selectedTag in widget.selectedTags) "Tags": selectedTag,
      for (var selectedIngredient in widget.selectedIngredients)
        "Ingredients": selectedIngredient
    };

    if (widget.selectedTags.isEmpty) {
      query.putIfAbsent("Tags", () => "");
    }

    if (widget.selectedIngredients.isEmpty) {
      query.putIfAbsent("Ingredients", () => "");
    }

    debugPrint(query.entries.toString());
    return FutureBuilder<List<Recipe>>(
      future: api.getRecipesWithQuery(APIConstants.recommendEndPoint, query),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.done) {
          debugPrint("SNAPSHOT: ${snapshot.data}");

          return Column(children: <Widget>[
            Expanded(
                child: ListView.builder(
              itemCount: snapshot.data?.length,
              itemBuilder: (context, index) {
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
    );
  }
}
