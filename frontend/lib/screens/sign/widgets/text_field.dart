import 'package:flutter/material.dart';

import '../../../constants.dart';

class CustomTextField extends StatelessWidget {
  final String labelText;
  final String hintText;
  final double bottomMargin;
  final TextEditingController controller;
  final bool obscureText;

  const CustomTextField({
    Key? key,
    required this.labelText,
    required this.hintText,
    required this.bottomMargin,
    required this.controller,
    required this.obscureText,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.fromLTRB(0, 0, 0, bottomMargin),
      width: MediaQuery.of(context).size.width * 0.9,
      decoration: BoxDecoration(boxShadow: [
        BoxShadow(
          color: Colors.black.withOpacity(0.2),
          offset: const Offset(
            0.0,
            10.0,
          ),
          blurRadius: 10.0,
          spreadRadius: -10.0,
        ),
      ],),
      child: TextField(
        controller: controller,
        decoration: InputDecoration(
          fillColor: Constants.secondaryColor,
          filled: true,
          border: OutlineInputBorder(
            borderRadius: BorderRadius.circular(30.0),
            borderSide: const BorderSide(
              width: 0,
              style: BorderStyle.none,
            ),
          ),
          focusedBorder: OutlineInputBorder(
            borderRadius: BorderRadius.circular(15.0),
            borderSide: BorderSide(
              width: 2,
              color: Colors.grey.shade800,
            )
          ),
          hintText: hintText,
          labelText: labelText,
        ),
        obscureText: obscureText,
      ),
    );
  }
}
