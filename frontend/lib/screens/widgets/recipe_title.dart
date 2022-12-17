import 'package:flutter/material.dart';
import '../../models/recipe.dart';

class RecipeTitle extends StatelessWidget {
  final Recipe recipe;
  final double padding;

  const RecipeTitle({ 
    super.key,
    required this.recipe,
    required this.padding
    });


  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(padding),
      child: Column(
        // Default value for crossAxisAlignment is CrossAxisAlignment.center.
        // We want to align title and description of recipes left:
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Text(
            recipe.name,
            style: Theme.of(context).textTheme.headline6,
          ),
          // Empty space:
          const SizedBox(height: 10.0),
          Row(
            children: [
              const Icon(Icons.tag_outlined, size: 20.0),
              const SizedBox(width: 5.0),
              Text(
                recipe.getTags(),
                style: Theme.of(context).textTheme.caption,
              ),
            ],
          ),
        ],
      ),
    );
  }
}