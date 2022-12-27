import 'dart:math';

import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';

import '../../../models/recipe.dart';

class RecipeTitle extends StatelessWidget {
  final Recipe recipe;
  final double padding;

  const RecipeTitle({super.key, required this.recipe, required this.padding});

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
        child: Padding(
      padding: EdgeInsets.all(padding),
      child: Column(
        // Default value for crossAxisAlignment is CrossAxisAlignment.center.
        // We want to align title and description of recipes left:
        crossAxisAlignment: CrossAxisAlignment.start,

        children: <Widget>[
          Row(children: [
            const Icon(Icons.fastfood_outlined, size: 22.0),
            const SizedBox(width: 5.0),
            Flexible(
                child: Text(
              overflow: TextOverflow.ellipsis,
              maxLines: 1,
              softWrap: false,
              recipe.name,
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
                for (int i = 0; i < min(2, recipe.tags!.length); i++)
                  Chip(
                    backgroundColor: Constants.primaryColor,
                    label: Text(
                      recipe.tags![i],
                      style: const TextStyle(
                        fontFamily: "Roboto",
                        fontWeight: FontWeight.bold,
                        fontStyle: FontStyle.italic,
                        fontSize: 14,
                        color: Constants.secondaryColor,
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
