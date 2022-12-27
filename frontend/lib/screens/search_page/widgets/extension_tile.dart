import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';

class CustomExpansionTile extends StatefulWidget {
  final List<String> selectedIngredients;
  final void Function(String) remove;

  const CustomExpansionTile({
    Key? key,
    required this.selectedIngredients,
    required this.remove,
  }) : super(key: key);

  @override
  State<CustomExpansionTile> createState() => _CustomExpansionTileState();
}

class _CustomExpansionTileState extends State<CustomExpansionTile> {
  @override
  Widget build(BuildContext context) {
    return Card(
      color: Theme.of(context).secondaryHeaderColor,
      elevation: 1,
      child: ExpansionTile(
        leading: const Icon(Icons.fastfood_outlined),
        title: const Text("Selected Ingredients"),
        initiallyExpanded: true,
        children: [
          Wrap(
              spacing: 5,
              children: widget.selectedIngredients
                  .map(
                    (e) => Chip(
                        backgroundColor: Constants.primaryColor,
                        label: Text(
                          e,
                          style: const TextStyle(
                            fontFamily: "Roboto",
                            fontWeight: FontWeight.bold,
                            fontStyle: FontStyle.italic,
                            fontSize: 16,
                            color: Constants.secondaryColor,
                          ),
                        ),
                        deleteIcon: const Icon(
                          Icons.remove_circle,
                          color: Constants.secondaryColor,
                        ),
                        onDeleted: () {
                          widget.remove(e);
                        }),
                  )
                  .toList()),
        ],
      ),
    );
  }
}
