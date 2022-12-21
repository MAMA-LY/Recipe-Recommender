import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/models/recipe.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/ingredients_view.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/nutrition_view.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/recipe_image.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page/widgets/recipe_title.dart';

class RecipePage extends StatefulWidget {
  final Recipe recipe;
  final bool inFavorites;
  const RecipePage(
      {super.key, required this.recipe, required this.inFavorites});

  List<String> getIngredientsNames() {
    List<String> ingredientsNames = [];
    for (var ingredient in recipe.ingredients!) {
      ingredientsNames.add(ingredient.amount);
    }
    return ingredientsNames;
  }

  @override
  State<RecipePage> createState() => _RecipePageState();
}

class _RecipePageState extends State<RecipePage>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;
  late ScrollController _scrollController;
  late bool _inFavorites;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(vsync: this, length: 2);
    _scrollController = ScrollController();
    _inFavorites = widget.inFavorites;
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
      body: NestedScrollView(
        controller: _scrollController,
        headerSliverBuilder: (BuildContext context, bool innerViewIsScrolled) {
          return <Widget>[
            SliverAppBar(
              backgroundColor: Colors.white,
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
              expandedHeight: 340.0,
              pinned: true,
              floating: true,
              elevation: 2.0,
              forceElevated: innerViewIsScrolled,
              bottom: TabBar(
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
      floatingActionButton: FloatingActionButton(

        onPressed: () {
          //TODO: update the user fav recipes
        },
        elevation: 2.0,
        backgroundColor: Constants.primaryColor,
        child: Icon(
          _inFavorites ? Icons.favorite : Icons.favorite_border,
          color: Theme.of(context).iconTheme.color,
        ),
      ),

     
    );
  }
}
