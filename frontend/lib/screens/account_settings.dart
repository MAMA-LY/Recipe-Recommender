import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
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
                children: [const SizedBox(
                  height: 75,
                  width: 15,
                ),
                  const Icon(Icons.person),
                  const SizedBox(
                    height: 75,
                    width: 5,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            ": ${snapshot.data!.username}",
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
                children: [const SizedBox(
                  height: 75,
                  width: 15,
                ),
                  const Icon(Icons.email_outlined),
                  const SizedBox(
                    height: 75,
                    width: 5,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            ": ${snapshot.data!.email}",
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
                  const SizedBox(
                  height: 75,
                  width: 15,
                ),
                  const Icon(Icons.height),
                  const SizedBox(
                    height: 75,
                    width: 5,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            ": ${snapshot.data!.height}",
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
                  const SizedBox(
                    height: 75,
                    width: 15,
                  ),
                  const Icon(Icons.monitor_weight_outlined),
                  const SizedBox(
                    height: 75,
                    width: 5,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return  Text(
                            ": ${snapshot.data!.weight}",
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
                children: [const SizedBox(
                  height: 75,
                  width: 15,
                ),
                  const Icon(Icons.calendar_today),
                  const SizedBox(
                    height: 75,
                    width: 5,
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            ": ${snapshot.data!.birthdate}",
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
