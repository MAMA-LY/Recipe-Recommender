import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';

import '../../../constants.dart';

class SearchBar extends StatefulWidget {
  final Function(String) update;
  final Function(String) suggest;

  const SearchBar({
    Key? key,
    required this.update,
    required this.suggest,
  }) : super(key: key);

  @override
  State<SearchBar> createState() => _SearchBarState();
}

class _SearchBarState extends State<SearchBar> {
  late TextEditingController controller;
  late String selectedIngredient;

  Widget buildGrid(
      context, Function(String) onSelected, Iterable<String> options) {
    return MasonryGridView.count(
      itemBuilder: (context, index) {
        return ElevatedButton(
          child: FittedBox(
            child: RichText(
              textAlign: TextAlign.center,
              text: TextSpan(
                  text: '${options.elementAt(index)}  ',
                  children: const [
                    WidgetSpan(
                        child: Icon(
                          Icons.add_circle_outline_outlined,
                          color: Constants.secondaryColor,
                        ),
                        alignment: PlaceholderAlignment.middle),
                  ]),
            ),
          ),
          onPressed: () {
            setState(() {
              onSelected(options.elementAt(index).toString());
            });
          },
        );
      },
      itemCount: min(options.length, 9),
      scrollDirection: Axis.vertical,
      crossAxisCount: 3,
      mainAxisSpacing: 5,
      crossAxisSpacing: 5,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Autocomplete<String>(
      fieldViewBuilder: (context, controller, focusNode, onEditingComplete) {
        this.controller = controller;
        return TextField(
          controller: controller,
          focusNode: focusNode,
          onEditingComplete: onEditingComplete,
          decoration: InputDecoration(
            border: OutlineInputBorder(
              borderRadius: BorderRadius.circular(30),
              borderSide: const BorderSide(color: Constants.primaryColor),
            ),
            focusedBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(30),
              borderSide: const BorderSide(color: Constants.primaryColor),
            ),
            enabledBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(30),
              borderSide: const BorderSide(color: Constants.primaryColor),
            ),
            hintText: "Search Ingredients",
            prefixIcon: const Icon(Icons.search),
          ),
        );
      },
      optionsBuilder: (TextEditingValue textEditingValue) {
        if (textEditingValue.text.isEmpty) {
          return const Iterable<String>.empty();
        } else {
          return widget.suggest(textEditingValue.text);
        }
      },
      optionsViewBuilder: (context, Function(String) onSelected, options) {
        return Align(
          alignment: Alignment.topLeft,
          child: Material(
            borderRadius: BorderRadius.circular(30),
            elevation: 4,
            child: Container(
              padding: const EdgeInsets.fromLTRB(10, 0, 10, 0),
              width: MediaQuery.of(context).size.width * 0.93,
              height: 100.0 * (min(options.length, 9) / 3).ceil(),
              child: buildGrid(context, onSelected, options),
            ),
          ),
        );
      },
      onSelected: (selectedIngredient) {
        widget.update(selectedIngredient);
        controller.text = "";
      },
    );
  }
}
