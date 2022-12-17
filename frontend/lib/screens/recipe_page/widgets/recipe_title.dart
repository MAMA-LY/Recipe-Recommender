import 'package:flutter/material.dart';
// ignore: import_of_legacy_library_into_null_safe
import 'package:flutter_tags/flutter_tags.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import '../../../models/recipe.dart';

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
          Row(
            children:[
              const Icon(Icons.fastfood_outlined, size: 22.0),
              const SizedBox(width: 5.0),
              Text(
                recipe.name,
                style: Theme.of(context).textTheme.titleLarge,
                selectionColor: const Color.fromARGB(174, 184, 178, 178),
              ),
            ]
          ),
          // Empty space:
          const SizedBox(height: 10.0),
          Row(
            children: [
              const Icon(Icons.tag_outlined, size: 20.0),
              const SizedBox(width: 5.0),
              Tags(
                alignment: WrapAlignment.center,
                itemCount: recipe.tags!.length,
                itemBuilder: (index) {
                  return ItemTags(
                    index: index,
                    title: recipe.tags![index],
                    color: Constants.primaryColor,
                    activeColor: Constants.primaryColor,
                    onPressed:null,
                    highlightColor: const Color.fromARGB(174, 184, 178, 178),
                    splashColor: const Color.fromARGB(174, 184, 178, 178),
                    elevation: 0.0,
                    borderRadius: const BorderRadius.all(Radius.circular(7.0)),
                    textColor: Constants.secondaryColor,
                    textActiveColor: Constants.secondaryColor,
                    removeButton: null,
                    textOverflow: TextOverflow.ellipsis,
                  );
                },
              ),
              
            ],
          ),
        ],
      ),
    );
  }
}