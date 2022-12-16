import 'package:flutter/material.dart';

import '../../../constants.dart';

class CustomButton extends StatelessWidget {
  final Function() onPressFn;
  final String text;

  const CustomButton({
    Key? key,
    required this.onPressFn,
    required this.text,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: MediaQuery.of(context).size.width * 0.5,
      height: MediaQuery.of(context).size.height * 0.12,
      padding: const EdgeInsets.all(20),
      child: ElevatedButton(
        style: ButtonStyle(
            shape:
            MaterialStateProperty.all<RoundedRectangleBorder>(
                RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20.0),
                ))),
        onPressed: onPressFn,
        child: Text(
          text,
          style: const TextStyle(
            color: Constants.secondaryColor,
            fontStyle: FontStyle.italic,
            fontFamily: "Roboto",
            fontWeight: FontWeight.bold,
            fontSize: 18,
          ),
        ),
      ),
    );
  }
}
