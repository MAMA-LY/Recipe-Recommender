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
    return Flexible(
      child: Container(
        
        constraints: BoxConstraints(
          minWidth: MediaQuery.of(context).size.width * 0.5,
          minHeight: MediaQuery.of(context).size.height * 0.11,
        ),
        padding: const EdgeInsets.all(20),
        child: ElevatedButton(
          style: ButtonStyle(
              shape:
              MaterialStateProperty.all<RoundedRectangleBorder>(
                  RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(30.0),
                  ))),
          onPressed: onPressFn,
          child: Text(
            text,
            style:  TextStyle(
              color:  Theme.of(context).secondaryHeaderColor,
              fontStyle: FontStyle.italic,
              fontFamily: "Roboto",
              fontWeight: FontWeight.bold,
              fontSize: 18,
            ),
          ),
        ),
      ),
    );
  }
}
