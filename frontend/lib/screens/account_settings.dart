import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:recipe_recommender_frontend/screens/page_view_controller.dart';


import '../constants.dart';

class AccountSettingsPage extends StatefulWidget {
  static String routeName = "/account_settings";

  const AccountSettingsPage({Key? key}) : super(key: key);

  @override
  State<AccountSettingsPage> createState() => _AccountSettingsPageState();
}


class _AccountSettingsPageState extends State<AccountSettingsPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme
          .of(context)
          .secondaryHeaderColor,
      appBar: AppBar(
        elevation: 0,
        backgroundColor: Theme
            .of(context)
            .secondaryHeaderColor,
        title: Text(
          "Profile",
          style: TextStyle(
              fontFamily: "Roboto",
              fontSize: 16,
              foreground: Paint()
                ..color = Constants.primaryColor
                ..strokeWidth = 10
          ),
        ),
        actions: [
            IconButton(
            icon: Image.asset('assets/images/logo.png'),
            onPressed: (){
              Navigator.of(context).pushAndRemoveUntil(
              MaterialPageRoute(
              builder: (BuildContext context) => const PageViewController()),
              (route) => false);
            },
        ),
      ],
      ),
      body: Stack(
        children: [
          Positioned(
            top: MediaQuery.of(context).size.height * 0.6,
            left: MediaQuery.of(context).size.width * 0.079,
            child: SvgPicture.asset(
              "assets/images/bottom.svg",
              color: Colors.orange,
            ),
          ),
          Column(
            children: [
              SizedBox(
                height: 50,
              ),
              Align(
                alignment: Alignment.center,
                child: Text(
                  'Username : ',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    fontFamily: "Roboto",
                    color: Theme
                        .of(context)
                        .focusColor,
                  ),
                ),
              ),
              SizedBox(
                height: 50,
              ),
              Align(
                alignment: Alignment.center,
                child: Text(
                  'Email : ',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    fontFamily: "Roboto",
                    color: Theme
                        .of(context)
                        .focusColor,
                  ),
                ),
              ),
            ],
          ),

        ],
      ),

    );
  }
}
