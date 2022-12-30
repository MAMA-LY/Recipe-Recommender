import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class CustomDateField extends StatelessWidget {
  final String labelText;
  final String hintText;
  final double bottomMargin;
  final TextEditingController controller;
  const CustomDateField({
    Key? key,
    required this.labelText,
    required this.hintText,
    required this.bottomMargin,
    required this.controller,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
        margin: const EdgeInsets.fromLTRB(0, 0, 0, 15),
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
        child: Center(
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
            icon: const Icon(Icons.calendar_today),
            labelText: labelText,
            hintText: hintText,
          ),
          readOnly: true,
          onTap: () async {
            DateTime? pickedDate = await showDatePicker(
                context: context,
                initialDate: DateTime.now(),
                firstDate: DateTime(1920),
                lastDate: DateTime(2100));

            if (pickedDate != null) {
              String formattedDate =
                  DateFormat('yyyy-MM-dd').format(pickedDate);
              debugPrint(formattedDate);
              controller.text = formattedDate;
            } else {
              debugPrint("Date is not selected");
            }
          },
        )));
  }
}
