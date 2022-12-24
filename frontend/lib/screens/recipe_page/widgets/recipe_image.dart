import 'package:flutter/material.dart';

class RecipeImage extends StatelessWidget {
  final String imageURL;

  const RecipeImage({
    super.key,
    required this.imageURL
    });

  @override
  Widget build(BuildContext context) {
    return ShaderMask(
      blendMode: BlendMode.multiply,
      shaderCallback: (bounds) =>
          LinearGradient(
              begin: Alignment.bottomCenter,
              end: Alignment.topCenter,
              colors: [Colors.black54, Colors.white.withOpacity(0.0)])
              .createShader(bounds),
      child: Image.network(
        imageURL,
        fit: BoxFit.fitHeight,
        height: MediaQuery.of(context).size.height * 0.35,
      ),
    );
  }
}