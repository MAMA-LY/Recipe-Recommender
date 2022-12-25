import 'package:babstrap_settings_screen/babstrap_settings_screen.dart';
import 'package:flutter/cupertino.dart';
import 'package:settings_ui/settings_ui.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';

import '../api/sign_api.dart';
import '../constants.dart';
import '../main.dart';

class SettingsPage extends StatelessWidget {
  static String routeName = "/settings";

  const SettingsPage({Key? key}) : super(key: key);

  Future<void> _signout(BuildContext context) async {
    await SignAPI.signout();
    // ignore: use_build_context_synchronously
    Navigator.of(context, rootNavigator: true)
        .pushReplacement(MaterialPageRoute(
            builder: (context) => const SignInPage(
                  initResp: "",
                )));
    cacheFile!.delete();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).secondaryHeaderColor,
      appBar: AppBar(
        elevation: 0,
        backgroundColor: Theme.of(context).secondaryHeaderColor,
        title: Text(
          "ورقة وقلم",
          style: TextStyle(
              fontFamily: "Arslan",
              fontSize: 30,
              foreground: Paint()
                ..color = Constants.primaryColor
                ..strokeWidth = 10),
        ),
        actions: [
          IconButton(
            onPressed: () {
              // TODO Navigate to nutrition page
            },
            icon: const Icon(
              Icons.analytics_outlined,
              color: Constants.primaryColor,
            ),
          ),
        ],
      ),
      body: SettingsList(
        sections: [
          SettingsSection(
            title:
                Text('Common', style: Theme.of(context).textTheme.titleLarge),
            tiles: [
              SettingsTile(
                title: Text(
                  'About',
                  style: Theme.of(context).textTheme.titleMedium,
                ),
                leading: const Icon(Icons.info_outline_rounded),
                onPressed: (BuildContext context) {},
              ),
              SettingsTile.switchTile(
                title: Text(
                  'Use System Theme',
                  style: Theme.of(context).textTheme.titleMedium,
                ),
                leading: const Icon(Icons.phone_android),
                activeSwitchColor: Theme.of(context).primaryColor,
                onToggle: (value) {
                  if (BuildApp.of(context)!.getTheme() != ThemeMode.system) {
                    BuildApp.of(context)!.changeTheme(ThemeMode.system);
                  } else {
                    BuildApp.of(context)!.changeTheme(ThemeMode.light);
                  }
                },
                initialValue:
                    BuildApp.of(context)!.getTheme() == ThemeMode.system,
              ),
              SettingsTile.switchTile(
                title: Text(
                  'Dark Mode',
                  style: Theme.of(context).textTheme.titleMedium,
                ),
                leading: const Icon(Icons.dark_mode_outlined),
                activeSwitchColor: Theme.of(context).primaryColor,
                onToggle: (value) {
                  if (BuildApp.of(context)!.getTheme() == ThemeMode.light &&
                      BuildApp.of(context)!.getTheme() != ThemeMode.system) {
                    BuildApp.of(context)!.changeTheme(ThemeMode.dark);
                  } else if (BuildApp.of(context)!.getTheme() !=
                      ThemeMode.system) {
                    BuildApp.of(context)!.changeTheme(ThemeMode.light);
                  }
                },
                initialValue:
                    BuildApp.of(context)!.getTheme() == ThemeMode.dark,
              )
            ],
          ),
          SettingsSection(
            title: Text(
              'Account',
              style: Theme.of(context).textTheme.titleLarge,
            ),
            tiles: [
              SettingsTile(
                title: Text(
                  'Profile',
                  style: Theme.of(context).textTheme.titleMedium,
                ),
                leading: const Icon(Icons.person),
                onPressed: (BuildContext context) {
                  //TODO: CALL THE ACCOUNT PAGE
                },
              ),
              SettingsTile.navigation(
                title: Text(
                  'Sign out',
                  style: Theme.of(context).textTheme.titleMedium,
                ),
                leading: const Icon(Icons.logout),
                onPressed: (context) => _signout(context),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
