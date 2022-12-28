import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:recipe_recommender_frontend/screens/page_view_controller.dart';
import 'package:recipe_recommender_frontend/models/user_profile.dart';

import '../api/user_profile_api.dart';
import '../main.dart';
import '../constants.dart';

class AccountSettingsPage extends StatefulWidget {
  static String routeName = "/account_settings";

  const AccountSettingsPage({Key? key}) : super(key: key);


  @override
  State<AccountSettingsPage> createState() => _AccountSettingsPageState();
}

class _AccountSettingsPageState extends State<AccountSettingsPage> {

  late Future<UserProfile> futureuserProfile;
  @override
  void initState() {
    super.initState();
    futureuserProfile = UserProfileAPI.fromCookie(session.cookie).getUserProfile();
  }
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
      body:
      Stack(
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
              Row(
                children: [
                  Icon(Icons.person),
                  SizedBox(
                    height: 50,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            snapshot.data!.username,
                            style: TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.bold,
                              fontFamily: "Roboto",
                              color: Theme.of(context).focusColor,
                            ),
                          );
                        } else if (snapshot.hasError) {
                          return Text('${snapshot.error}');
                        } else {
                          return const Center(
                              child: CircularProgressIndicator(
                            color: Constants.primaryColor,
                          ));
                        }
                      },
                    ),
                  ),
                ],
              ),
              Row(
                children: [
                  Icon(Icons.email_outlined),
                  SizedBox(
                    height: 50,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            snapshot.data!.email,
                            style: TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.bold,
                              fontFamily: "Roboto",
                              color: Theme.of(context).focusColor,
                            ),
                          );
                        } else if (snapshot.hasError) {
                          return Text('${snapshot.error}');
                        } else {
                          return const Center(
                              child: CircularProgressIndicator(
                            color: Constants.primaryColor,
                          ));
                        }
                      },
                    ),
                  ),
                ],
              ),
              Row(
                children: [
                  Icon(Icons.height),
                  SizedBox(
                    height: 50,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            (snapshot.data!.height).toString(),
                            style: TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.bold,
                              fontFamily: "Roboto",
                              color: Theme.of(context).focusColor,
                            ),
                          );
                        } else if (snapshot.hasError) {
                          return Text('${snapshot.error}');
                        } else {
                          return const Center(
                              child: CircularProgressIndicator(
                            color: Constants.primaryColor,
                          ));
                        }
                      },
                    ),
                  ),
                ],
              ),
              Row(
                children: [
                  Icon(Icons.monitor_weight_outlined),
                  SizedBox(
                    height: 50,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            'weight : ' + (snapshot.data!.weight).toString(),
                            style: TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.bold,
                              fontFamily: "Roboto",
                              color: Theme.of(context).focusColor,
                            ),
                          );
                        } else if (snapshot.hasError) {
                          return Text('${snapshot.error}');
                        } else {
                          return const Center(
                              child: CircularProgressIndicator(
                            color: Constants.primaryColor,
                          ));
                        }
                      },
                    ),
                  ),
                ],
              ),
              Row(
                children: [
                  Icon(Icons.calendar_today),
                  SizedBox(
                    height: 50,
                  ),
                  SizedBox(
                    height: 50,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            snapshot.data!.birthdate,
                            style: TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.bold,
                              fontFamily: "Roboto",
                              color: Theme.of(context).focusColor,
                            ),
                          );
                        } else if (snapshot.hasError) {
                          return Text('${snapshot.error}');
                        } else {
                          return const Center(
                              child: CircularProgressIndicator(
                            color: Constants.primaryColor,
                          ));
                        }
                      },
                    ),
                  ),
                ],
              ),
            ],
          ),

        ],
      ),

    );
  }
}
