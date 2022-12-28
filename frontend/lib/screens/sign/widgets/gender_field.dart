import 'package:flutter/material.dart';

class GenderWidget extends StatelessWidget {
  final VoidCallback onclick;
  final String title;
  final IconData icon;

  final bool isSelected;

  const GenderWidget({super.key, 
    required this.isSelected,
    required this.onclick,
    required this.title,
    required this.icon,
  });

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onclick,
      child: Container(
        color:
            isSelected ? Colors.transparent : Colors.transparent, 
        child: Center(
            child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            Text(
              title,
            ),
            Icon(
              icon,
              color: isSelected == true ? Colors.orange: Theme.of(context).focusColor.withOpacity(0.3),
              size: 80,
            ),
            const SizedBox(
              height: 8,
            )
          ],
        )),
      ),
    );
  }
}