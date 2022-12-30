import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:recipe_recommender_frontend/models/user_profile.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

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
              const SizedBox(height: 20),
              Row(

                children: [

                  const SizedBox(
                      width: 15,
                      height: 50),

                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return CustomTextField(
                            enabled: false,
                            hintText: "Enter your username here..",
                            labelText: snapshot.data!.username,
                            bottomMargin: 20,
                            controller: TextEditingController(),
                            obscureText: false,
                            icon: Icons.person,
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
                  width: 15,
                  height: 50),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return  CustomTextField(
                              enabled: false,
                              hintText: "Enter your username here..",
                              labelText: snapshot.data!.email,
                              bottomMargin: 20,
                              controller: TextEditingController(),
                              obscureText: false,
                              icon: Icons.email_outlined,
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
                      width: 15,
                      height: 50),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return CustomTextField(
                            hintText: "Enter your height here..",
                            labelText: snapshot.data!.height.toString(),
                            bottomMargin: 15,
                            controller: TextEditingController(),
                            obscureText: false,
                            icon: Icons.height,
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
                      width: 15,
                      height: 50
                  ),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return  CustomTextField(
                          hintText: "Enter your weight here..",
                          labelText: snapshot.data!.weight.toString(),
                          bottomMargin: 15,
                          controller: TextEditingController(),
                          obscureText: false,
                          icon: Icons.monitor_weight_outlined,
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
                      width: 15,
                      height: 50),
                  Align(
                    alignment: Alignment.center,
                    child: FutureBuilder<UserProfile>(
                      future: futureuserProfile,
                      builder: (context, snapshot) {
                        if (snapshot.hasData) {
                          return CustomTextField(
                              hintText: "Enter your birthdate here..",
                              labelText: snapshot.data!.birthdate,
                              bottomMargin: 15,
                              controller: TextEditingController(),
                              obscureText: false,
                              icon: Icons.calendar_today,
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
