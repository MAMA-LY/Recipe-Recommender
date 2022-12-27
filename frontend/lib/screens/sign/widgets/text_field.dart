import 'package:flutter/material.dart';

import '../../../constants.dart';

class CustomTextField extends StatelessWidget {
  final String labelText;
  final String hintText;
  final double bottomMargin;
  final TextEditingController controller;
  final bool obscureText;
  final IconData icon;

  const CustomTextField({
    Key? key,
    required this.labelText,
    required this.hintText,
    required this.bottomMargin,
    required this.controller,
    required this.obscureText,
    required this.icon,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.fromLTRB(0, 0, 0, bottomMargin),
      width: MediaQuery.of(context).size.width * 0.9,
      decoration: BoxDecoration(
        color: Theme.of(context).secondaryHeaderColor,
        boxShadow: [
          BoxShadow(
            color: Theme.of(context).focusColor.withOpacity(0.3),
            offset: const Offset(
              0.0,
              10.0,
            ),
            blurRadius: 10.0,
            spreadRadius: -10.0,
          ),
        ],
      ),
      child: TextField(
        controller: controller,
        decoration: InputDecoration(
          labelStyle: TextStyle(color: Theme.of(context).primaryColor),
          hintStyle:
              TextStyle(color: Theme.of(context).focusColor.withOpacity(0.3)),
          fillColor: Theme.of(context).secondaryHeaderColor,
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
                color: Theme.of(context).focusColor.withOpacity(0.1),
              )),
          icon:  Icon(icon),
          hintText: hintText,
          labelText: labelText,
        ),
        obscureText: obscureText,
      ),
    );
  }
}
