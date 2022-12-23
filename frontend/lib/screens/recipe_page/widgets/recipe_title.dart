import 'package:flutter/material.dart';
// ignore: import_of_legacy_library_into_null_safe
import 'package:flutter_tags/flutter_tags.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import '../../../models/recipe.dart';

class RecipeTitle extends StatelessWidget {
  final Recipe recipe;
  final double padding;

<<<<<<< HEAD
  const RecipeTitle({ 
    super.key,
    required this.recipe,
    required this.padding
    });


  @override
  Widget build(BuildContext context) {
    return Padding(
=======
  const RecipeTitle({super.key, required this.recipe, required this.padding});

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
        child: Padding(
>>>>>>> main
      padding: EdgeInsets.all(padding),
      child: Column(
        // Default value for crossAxisAlignment is CrossAxisAlignment.center.
        // We want to align title and description of recipes left:
        crossAxisAlignment: CrossAxisAlignment.start,
<<<<<<< HEAD
        
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
=======

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
>>>>>>> main
          // Empty space:
          const SizedBox(height: 10.0),
          Row(
            children: [
              const Icon(Icons.tag_outlined, size: 20.0),
              const SizedBox(width: 5.0),
              Tags(
                alignment: WrapAlignment.center,
<<<<<<< HEAD
                itemCount: recipe.tags!.length,
=======
                itemCount: recipe.tags!.length > 3 ? 3 : recipe.tags!.length,
>>>>>>> main
                itemBuilder: (index) {
                  return ItemTags(
                    index: index,
                    title: recipe.tags![index],
                    color: Constants.primaryColor,
                    activeColor: Constants.primaryColor,
<<<<<<< HEAD
                    onPressed:null,
=======
                    onPressed: null,
>>>>>>> main
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
<<<<<<< HEAD
              
=======
>>>>>>> main
            ],
          ),
        ],
      ),
<<<<<<< HEAD
    );
  }
}
=======
    ));
  }
}
>>>>>>> main
