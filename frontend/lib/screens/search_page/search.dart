import 'package:filter_list/filter_list.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
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

  //final List<String> ingredients;

  const SearchPage({
    super.key,
    //required this.ingredients,
  });

  @override
  State<SearchPage> createState() => _SearchPageState();
}

class _SearchPageState extends State<SearchPage> {
  late TextEditingController controller;
  late List<String> ingredients = [
    "egg",
    "eggplants",
    "whole wheat pastry flour",
    "lemon pie filling",
    "salt and pepper",
    "corn meal",
    "shrimp",
    "egg replacement",
    "red peppers"
  ];
  late List<String> selectedIngredients = [];
  late List<String> selectedTags = [];

  Future<void> autoCompleteUpdate(String ingredient) async {
    setState(() {
      selectedIngredients.add(ingredient);
      ingredients.remove(ingredient);
    });
  }

  Future<void> expansionTileUpdate(String ingredient) async {
    setState(() {
      selectedIngredients.remove(ingredient);
      ingredients.add(ingredient);
    });
  }

  Iterable<String> autoCompleteSuggest(String text) {
    return ingredients
        .where((element) => element.toLowerCase().contains(text.toLowerCase()));
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
        body: Padding(
          padding: const EdgeInsets.fromLTRB(15.0, 10.0, 15.0, 15.0),
          child: Column(
            children: [
              Stack(
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
                        backgroundColor: Constants.thirdColor,
                      ),
                      child: const Icon(
                        Icons.filter_alt_outlined,
                        color: Constants.secondaryColor,
                      ),
                    ),
                  )
                ],
              ),
              const SizedBox(
                height: 10,
              ),
              CustomExpansionTile(
                  selectedIngredients: selectedIngredients,
                  remove: expansionTileUpdate),
            ],
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
          child: const Icon(Icons.fastfood),
        ),
        floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
      ),
    );
  }
}
