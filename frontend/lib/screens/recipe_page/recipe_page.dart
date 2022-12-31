import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/api_constants.dart';
import 'package:recipe_recommender_frontend/api/user_profile_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/models/user_profile.dart';
import 'package:recipe_recommender_frontend/screens/calories_page/calories_page.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/ingredients_view.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/nutrition_view.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/recipe_image.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/recipe_title.dart';
import 'package:recipe_recommender_frontend/screens/sign/ResponseEnum.dart';
import 'package:share_plus/share_plus.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../../api/recipes_api.dart';
import '../../main.dart';

class RecipePage extends StatefulWidget {
  final Recipe recipe;
  final bool inFavorites;

  const RecipePage(
      {super.key, required this.recipe, required this.inFavorites});

  List<String> getIngredientsNames() {
    List<String> ingredientsNames = [];
    for (var ingredient in recipe.ingredients!) {
      ingredientsNames.add(ingredient.amount!);
    }
    return ingredientsNames;
  }

  @override
  State<RecipePage> createState() => _RecipePageState();
}

class _RecipePageState extends State<RecipePage>
    with SingleTickerProviderStateMixin {
  RecipesAPI api = RecipesAPI.fromCookie(session.cookie);

  late TabController _tabController;
  late ScrollController _scrollController;
  late bool _inFavorites = false;
  Color favColor = Constants.secondaryColor;
  @override
  void initState() {
    super.initState();
    _tabController = TabController(vsync: this, length: 2);
    _scrollController = ScrollController();
    _inFavorites = widget.inFavorites;
    if (widget.recipe.favourite != null) {
      if (widget.recipe.favourite == true) {
        setState(() {
          _inFavorites = true;
        });
      }
    }
  }

  @override
  void dispose() {
    // "Unmount" the controllers:
    _tabController.dispose();
    _scrollController.dispose();
    super.dispose();
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).secondaryHeaderColor,
      body: NestedScrollView(
        controller: _scrollController,
        headerSliverBuilder: (BuildContext context, bool innerViewIsScrolled) {
          return <Widget>[
            SliverAppBar(
              backgroundColor: Theme.of(context).secondaryHeaderColor,
              flexibleSpace: FlexibleSpaceBar(
                collapseMode: CollapseMode.pin,
                background: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    RecipeImage(imageURL: widget.recipe.image),
                    RecipeTitle(padding: 25.0, recipe: widget.recipe),
                  ],
                ),
              ),
              expandedHeight: 450.0,
              pinned: true,
              floating: true,
              elevation: 2.0,
              forceElevated: innerViewIsScrolled,
              bottom: TabBar(
                indicatorColor: Theme.of(context).primaryColor,
                labelColor: Constants.primaryColor,
                tabs: const <Widget>[
                  Tab(text: "Ingredients"),
                  Tab(text: "Nutrition")
                ],
                controller: _tabController,
              ),
            ),
          ];
        },
        body: TabBarView(
          controller: _tabController,
          children: <Widget>[
            IngredientsView(ingredients: widget.getIngredientsNames()),
            NutritionView(nutrition: widget.recipe.nutrition!),
          ],
        ),
      ),
      // floatingActionButton: FloatingActionButton(

      //   onPressed: () {
      //     //TODO: update the user fav recipes
      //   }, 
      //   elevation: 2.0,
      //   backgroundColor: Constants.primaryColor,
      //   child: Icon(
      //     _inFavorites ? Icons.favorite : Icons.favorite_border,
      //     color: Theme.of(context).iconTheme.color,
      //   ),
      // ),
      floatingActionButton: PopupMenuButton<String>(
        icon: const Icon(Icons.more_vert, color: Constants.primaryColor),
        splashRadius: 20,
        iconSize: 30,
        shape: const RoundedRectangleBorder(
            borderRadius: BorderRadius.all(Radius.circular(15.0))),
        itemBuilder: (BuildContext context) {
          return {"Eat", "Share", "Save"}.map((String choice) {
            if (choice == "Eat"){
              return PopupMenuItem<String>(
                  onTap: () async {
                    await CalorieWatcher.validateDailyCalories();
                    SharedPreferences prefs = await SharedPreferences.getInstance();

                    int recipeCalories = widget.recipe.nutrition!.calories;
                    int recipeCarbs = widget.recipe.nutrition!.carbs;
                    int recipeProteins = widget.recipe.nutrition!.proteins;
                    int recipeFats = widget.recipe.nutrition!.fats;

                    int consumedCalories = prefs.getInt("consumedCalories") ?? 0;
                    int consumedCarbs = prefs.getInt("consumedCarbs") ?? 0;
                    int consumedProteins= prefs.getInt("consumedProteins") ?? 0;
                    int consumedFats = prefs.getInt("consumedFats") ?? 0;

                    await prefs.setInt("consumedCalories", consumedCalories + recipeCalories);
                    await prefs.setInt("consumedCarbs", consumedCarbs + recipeCarbs);
                    await prefs.setInt("consumedProteins", consumedProteins + recipeProteins);
                    await prefs.setInt("consumedFats", consumedFats + recipeFats);
                    await prefs.reload();
                  },
                  value: choice,
                  child: Row(children: [
                    const Icon(Icons.add,
                        color: Constants.secondaryColor),
                    const SizedBox(width: 5.0),
                    Text("Eat",
                        style: TextStyle(
                            color: Theme.of(context).secondaryHeaderColor))
                  ]));
            } else if (choice == "Save") {
              return PopupMenuItem<String>(
                  onTap: () async {
                    if (_inFavorites) {
                      String response =
                          await api.removeFavRecipe(widget.recipe.id);
                      if (response == Response.RemovedFavRecipe.name) {
                        setState(() {
                          _inFavorites = false;
                        });
                      }
                    } else {
                      String response =
                          await api.addFavRecipe(widget.recipe.id);
                      if (response == Response.AddedFavRecipe.name) {
                        setState(() {
                          _inFavorites = true;
                        });
                      }
                    }
                  },
                  value: choice,
                  child: Row(children: [
                    Icon(_inFavorites ? Icons.favorite : Icons.favorite_border,
                        color: Constants.secondaryColor),
                    const SizedBox(width: 5.0),
                    Text("Save",
                        style: TextStyle(
                            color: Theme.of(context).secondaryHeaderColor))
                  ]));
            } else {
              return PopupMenuItem<String>(
                  onTap: () async {
                    final box = context.findRenderObject() as RenderBox?;
                    await Share.share(
                      "https://${APIConstants.baseUrl}/share/recipe?id=${widget.recipe.id}",
                      subject: "Recipe Share",
                      sharePositionOrigin:
                          box!.localToGlobal(Offset.zero) & box.size,
                    );
                  },
                  value: choice,
                  child: Row(children: [
                    Icon(
                      Icons.share,
                      color: Theme.of(context).secondaryHeaderColor,
                    ),
                    const SizedBox(width: 5.0),
                    Text("Share",
                        style: TextStyle(
                            color: Theme.of(context).secondaryHeaderColor))
                  ]));
            }
          }).toList();
        },
        color: Constants.primaryColor,
      ),
    );
  }
}
