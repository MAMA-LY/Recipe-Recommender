import 'package:filter_list/filter_list.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/ingredients_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/main.dart';
import 'package:recipe_recommender_frontend/screens/search_page/widgets/extension_tile.dart';
import 'package:recipe_recommender_frontend/screens/search_page/widgets/search_bar.dart';

import 'widgets/search_result.dart';

final List<String> tags = [
  "brunch",
  "South American",
  "breakfast",
  "European",
  "salad",
  "winter",
  "Spanish",
  "seasoning",
  "easter",
  "Indian",
  "bbq",
  "Jewish",
  "snack",
  "Irish",
  "summer",
  "antipasto",
  "antipasti",
  "French",
  "vegan",
  "st patricks day",
  "Eastern European",
  "mother's day",
  "Thai",
  "Asian",
  "Middle Eastern",
  "sauce",
  "British",
  "Korean",
  "main course",
  "appetizer",
  "dairy free",
  "Chinese",
  "Creole",
  "lacto ovo vegetarian",
  "father's day",
  "dip",
  "whole 30",
  "main dish",
  "hor d'oeuvre",
  "bread",
  "English",
  "paleolithic",
  "super bowl",
  "marinade",
  "Latin American",
  "frosting",
  "Greek",
  "drink",
  "4th of july",
  "Barbecue",
  "American",
  "Japanese",
  "dinner",
  "thanksgiving",
  "morning meal",
  "wedding",
  "spring",
  "christmas",
  "hanukkah",
  "valentine's day",
  "ketogenic",
  "fingerfood",
  "fodmap friendly",
  "German",
  "Italian",
  "Scottish",
  "African",
  "condiment",
  "gluten free",
  "lunch",
  "side dish",
  "Vietnamese",
  "soup",
  "Southern",
  "fall",
  "halloween",
  "dessert",
  "Mexican",
  "beverage",
  "primal",
  "Cajun",
  "Mediterranean",
  "spread",
  "starter",
  "icing",
  "pescatarian"
];

class SearchPage extends StatefulWidget {
  static String routeName = "/search";

  const SearchPage({
    super.key,
  });

  @override
  State<SearchPage> createState() => _SearchPageState();
}

class _SearchPageState extends State<SearchPage> {
  late TextEditingController controller;
  IngredientsAPI ingredientsAPI = IngredientsAPI.fromCookie(session.cookie);
  List<String> ingredients = [];
  late List<String> selectedIngredients = [];
  late List<String> selectedTags = [];

  void asyncInitState() async {}

  Future<void> autoCompleteUpdate(String ingredient) async {
    setState(() {
      selectedIngredients.add(ingredient);
      ingredients.remove(ingredient);
    });
  }

  void expansionTileUpdate(String ingredient) async {
    setState(() {
      selectedIngredients.remove(ingredient);
      ingredients.add(ingredient);
    });
  }

  Future<Iterable<String>> autoCompleteSuggest(String text) async {
    if (ingredients.isEmpty) {
      ingredients = await ingredientsAPI.getIngredients();
    }
    ingredients.sort();
    return ingredients.where(
        (element) => element.toLowerCase().startsWith(text.toLowerCase()));
  }

  void openFilterDialog() async {
    await FilterListDialog.display<String>(
      context,
      listData: tags,
      selectedListData: selectedTags,
      choiceChipLabel: (tag) => tag,
      validateSelectedItem: (list, val) => list!.contains(val),
      onItemSearch: (tag, query) {
        return tag.toLowerCase().contains(query.toLowerCase());
      },
      onApplyButtonClick: (list) {
        setState(() {
          selectedTags = List.from(list!);
          debugPrint(selectedTags[0]);
        });
        Navigator.pop(context);
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        backgroundColor: Constants.secondaryColor,
        appBar: AppBar(
          elevation: 0.0,
          backgroundColor: Constants.secondaryColor,
          bottom: PreferredSize(
            preferredSize: const Size.fromHeight(12),
            child: Padding(
              padding: const EdgeInsets.fromLTRB(15.0, 0.0, 15.0, 0.0),
              child: Stack(
                alignment: AlignmentDirectional.centerEnd,
                children: [
                  SearchBar(
                      update: autoCompleteUpdate, suggest: autoCompleteSuggest),
                  Padding(
                    padding: const EdgeInsets.only(right: 10),
                    child: ElevatedButton(
                      onPressed: openFilterDialog,
                      style: ElevatedButton.styleFrom(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30.0),
                        ),
                      ),
                      child: const Icon(
                        Icons.filter_alt_outlined,
                        color: Constants.secondaryColor,
                      ),
                    ),
                  )
                ],
              ),
            ),
          ),
        ),
        body: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.fromLTRB(10.0, 0.0, 10.0, 0.0),
            child: Column(
              children: [
                const SizedBox(
                  height: 10,
                ),
                CustomExpansionTile(
                    selectedIngredients: selectedIngredients,
                    remove: expansionTileUpdate),
              ],
            ),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          heroTag: "recommend",
          onPressed: () => setState(() {
            Navigator.push(
                context,
                MaterialPageRoute(
                    builder: (context) => SearchResult(
                        selectedIngredients: selectedIngredients,
                        selectedTags: selectedTags)));
          }),
          tooltip: 'Recommend',
          child: const Icon(
            Icons.fastfood,
            color: Constants.secondaryColor,
          ),
        ),
        floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
      ),
    );
  }
}
