import 'package:flutter/material.dart';

import '../../../constants.dart';

class CustomExpansionTile extends StatefulWidget {
  final List<String> selectedIngredients;
  final Function(String) remove;

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
    return ExpansionTile(
      title: const Text("Selected Ingredients"),
      initiallyExpanded: true,
      children: widget.selectedIngredients
          .map((e) => Card(
        child: ListTile(
          trailing: SizedBox(
            width: MediaQuery.of(context).size.width * 0.1,
            height: MediaQuery.of(context).size.height * 0.1,
            child: FloatingActionButton(
              backgroundColor: Colors.red[800],
              onPressed: () {
                widget.remove(e);
              },
              child: const Icon(
                Icons.remove_circle_outline,
                color: Constants.secondaryColor,
              ),
            ),
          ),
          title: Text(e),
        ),
      ))
          .toList(),
    );
  }
}
