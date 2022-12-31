import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';
import 'package:recipe_recommender_frontend/constants.dart';

import '../../../api/recipes_api.dart';
import '../../../main.dart';
import '../../../models/recipe.dart';

class RecipeTitle extends StatefulWidget {
  Recipe recipe;
  final double padding;
  final bool share;
  RecipeTitle(
      {super.key,
      required this.recipe,
      required this.padding,
      required this.share});

  @override
  State<RecipeTitle> createState() => _RecipeTitleState();
}

class _RecipeTitleState extends State<RecipeTitle> {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
        child: Padding(
      padding: EdgeInsets.all(widget.padding),
      child: Column(
        // Default value for crossAxisAlignment is CrossAxisAlignment.center.
        // We want to align title and description of recipes left:
        crossAxisAlignment: CrossAxisAlignment.start,

        children: <Widget>[
          Row(
            children: [
              RatingBar.builder(
                initialRating: widget.recipe.currentUserCount,
                itemSize: 30,
                minRating: 1,
                direction: Axis.horizontal,
                allowHalfRating: true,
                itemCount: !widget.share ?  5 : 0,
                itemPadding: EdgeInsets.symmetric(horizontal: 0.5),
                itemBuilder:  (context, _) {
                    return const Icon(Icons.star, color: Colors.amber);
                } ,
                onRatingUpdate: (rating) async {
                  if (!widget.share) {
                    RecipesAPI api = RecipesAPI.fromCookie(session.cookie);
                    Recipe apiRecipe =
                        await api.rateRecipe(widget.recipe.id, rating);
                    setState(() {
                      widget.recipe = apiRecipe;
                      debugPrint(widget.recipe.rate.toString());
                    });
                  }
                },
              ),
              const SizedBox(width: 10),
              Text("Total Rating: ${widget.recipe.rate}", softWrap: true),
            ],
          ),

          Row(children: [
            const Icon(Icons.fastfood_outlined, size: 22.0),
            const SizedBox(width: 5.0),
            Flexible(
                child: Text(
              overflow: TextOverflow.ellipsis,
              maxLines: 1,
              softWrap: false,
              widget.recipe.name,
              style: Theme.of(context).textTheme.titleLarge,
              selectionColor: const Color.fromARGB(174, 184, 178, 178),
            )),
          ]),
          // Empty space:
          const SizedBox(height: 10.0),
          Row(
            children: [
              const Icon(Icons.tag_outlined, size: 20.0),
              const SizedBox(width: 5.0),
              Wrap(spacing: 5, children: [
                for (int i = 0; i < min(2, widget.recipe.tags!.length); i++)
                  Chip(
                    backgroundColor: Constants.primaryColor,
                    label: Text(
                      widget.recipe.tags![i],
                      style: TextStyle(
                        fontFamily: "Roboto",
                        fontWeight: FontWeight.bold,
                        fontStyle: FontStyle.italic,
                        fontSize: 14,
                        color: Theme.of(context).secondaryHeaderColor,
                      ),
                    ),
                  ),
              ]),
            ],
          ),
        ],
      ),
    ));
  }
}
