import 'package:flutter/material.dart';

import '../constants.dart';

class SplashScreenPage extends StatelessWidget {
  static String routeName = "/splash";

  const SplashScreenPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Constants.secondaryColor,
      body: Center(
        child: SizedBox(
          height: MediaQuery.of(context).size.height / 2,
          width: MediaQuery.of(context).size.width / 2,
          child: const Image(image: AssetImage("assets/images/SplashLogo.png")),
        ),
      ),
    );
  }
}
