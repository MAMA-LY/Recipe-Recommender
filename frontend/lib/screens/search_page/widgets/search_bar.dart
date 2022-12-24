import 'package:flutter/material.dart';
import 'package:flutter_typeahead/flutter_typeahead.dart';
import 'package:substring_highlight/substring_highlight.dart';

import '../../../constants.dart';

class SearchBar extends StatefulWidget {
  final Future<void> Function(String) update;
  final Future<Iterable<String>> Function(String) suggest;

  const SearchBar({
    Key? key,
    required this.update,
    required this.suggest,
  }) : super(key: key);

  @override
  State<SearchBar> createState() => _SearchBarState();
}

class _SearchBarState extends State<SearchBar> {
  late String selectedIngredient;
  late String userInput;

  @override
  Widget build(BuildContext context) {
    return TypeAheadField<String>(
      suggestionsBoxDecoration: SuggestionsBoxDecoration(
        elevation: 1,
        borderRadius: BorderRadius.circular(10.0),
        color: Colors.orange[50],
      ),
      debounceDuration: const Duration(microseconds: 500),
      textFieldConfiguration: TextFieldConfiguration(
        decoration: InputDecoration(
          labelText: "Ingredient",
          prefixIcon: const Icon(Icons.search),
          enabledBorder: OutlineInputBorder(
            borderRadius: BorderRadius.circular(30.0),
            borderSide: BorderSide(color: Colors.grey.shade300, width: 3),
          ),
          focusedBorder: OutlineInputBorder(
            borderRadius: BorderRadius.circular(15.0),
            borderSide:
                const BorderSide(color: Constants.primaryColor, width: 2),
          ),
          hintText: "Search Ingredients",
        ),
      ),
      suggestionsCallback: (pattern) {
        userInput = pattern;
        return widget.suggest(pattern);
      },
      itemBuilder: (context, String suggestion) {
        return ListTile(
          leading: const Icon(
            Icons.add_circle,
            color: Constants.primaryColor,
          ),
          title: SubstringHighlight(
            text: suggestion,
            term: userInput,
            textStyle: const TextStyle(
              color: Colors.black87,
              fontWeight: FontWeight.normal,
              fontSize: 16,
              fontFamily: "Roboto",
            ),
            textStyleHighlight: const TextStyle(
              color: Constants.primaryColor,
              fontWeight: FontWeight.bold,
            ),
          ),
        );
      },
      onSuggestionSelected: (String selectedIngredient) {
        widget.update(selectedIngredient);
      },
      noItemsFoundBuilder: (context) => const SizedBox(
        height: 80,
        child: Center(
          child: Text(
            'No Ingredients Found.',
            style: TextStyle(fontSize: 20),
          ),
        ),
      ),
    );
  }
}
