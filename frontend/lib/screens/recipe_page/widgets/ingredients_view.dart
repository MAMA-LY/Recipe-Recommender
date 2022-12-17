import 'package:flutter/material.dart';

class IngredientsView extends StatelessWidget {
  final List<String> ingredients;

  const IngredientsView( {super.key, required this.ingredients});

  @override
  Widget build(BuildContext context) {
    List<Widget> children = <Widget>[];
    for (var item in ingredients) {
      children.add(
        Row(
          children: <Widget>[
            const Icon(Icons.done),
            const SizedBox(width: 5.0),
            Text(item),
          ],
        ),
      );
      // Add spacing between the lines:
      children.add(
        const SizedBox(
          height: 5.0,
        ),
      );
    }
    return ListView(
      padding: const EdgeInsets.fromLTRB(25.0, 25.0, 25.0, 75.0),
      children: children,
    );
  }
}

