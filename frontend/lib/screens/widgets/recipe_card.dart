import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/screens/recipe_page.dart';

class RecipeCard extends StatelessWidget {
  final String id;
  final String name;
  final String thumbnailUrl;

  const RecipeCard({
    super.key,
    required this.id,
    required this.name,
    required this.thumbnailUrl,
  });

  @override
  Widget build(BuildContext context) {
    return TextButton(
      child: Container(
        margin: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
        width: MediaQuery.of(context).size.width,
        height: MediaQuery.of(context).size.height / 4,
        decoration: BoxDecoration(
          color: Colors.black,
          borderRadius: BorderRadius.circular(15),
          boxShadow: [
            BoxShadow(
              color: Colors.black.withOpacity(0.6),
              offset: const Offset(
                0.0,
                10.0,
              ),
              blurRadius: 10.0,
              spreadRadius: -6.0,
            ),
          ],
          image: DecorationImage(
            colorFilter: ColorFilter.mode(
              Colors.black.withOpacity(0.20),
              BlendMode.multiply,
            ),
            image: Image.network(thumbnailUrl,
                    height: MediaQuery.of(context).size.height)
                .image,
            fit: BoxFit.cover,
          ),
        ),
        child: Stack(
          children: [
            Align(
              alignment: Alignment.center,
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 5.0),
                child: Text(
                  name,
                  style: const TextStyle(
                    fontSize: 24,
                    color: Constants.secondaryColor,
                    fontFamily: "Roboto",
                    fontWeight: FontWeight.bold,
                  ),
                  overflow: TextOverflow.ellipsis,
                  maxLines: 2,
                  textAlign: TextAlign.center,
                ),
              ),
            ),
          ],
        ),
      ),
      onPressed: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => const RecipePage()),
        );
      },
    );
  }
}
