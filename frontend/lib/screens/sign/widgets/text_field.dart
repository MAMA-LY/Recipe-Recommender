import 'package:flutter/material.dart';

import '../../../constants.dart';

class CustomTextField extends StatelessWidget {
  final String promptText;
  final int bottomPadding;
  final TextEditingController controller;
  final bool obscureText;
<<<<<<< HEAD

=======
>>>>>>> main
  const CustomTextField({
    Key? key,
    required this.promptText,
    required this.bottomPadding,
    required this.controller,
    required this.obscureText,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.fromLTRB(0, 0, 0, 25),
      width: MediaQuery
          .of(context)
          .size
          .width * 0.8,
      decoration: BoxDecoration(boxShadow: [
        BoxShadow(
          color: Colors.black.withOpacity(0.2),
          offset: const Offset(
            0.0,
            12.0,
          ),
          blurRadius: 10.0,
          spreadRadius: -10.0,
        ),
      ]),
      child: TextField(
        controller: controller,
        decoration: InputDecoration(
          fillColor: Constants.secondaryColor,
          filled: true,
          border: OutlineInputBorder(
            borderRadius: BorderRadius.circular(20.0),
            borderSide: const BorderSide(
              width: 0,
              style: BorderStyle.none,
            ),
          ),
<<<<<<< HEAD
=======
          hintText: promptText,
>>>>>>> main
          labelText: promptText,
        ),
        obscureText: obscureText,
      ),
    );
  }
}
