import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:persistent_bottom_nav_bar/persistent_tab_view.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/screens/favorites/favorites.dart';
import 'package:recipe_recommender_frontend/screens/home/home.dart';
import 'package:recipe_recommender_frontend/screens/meal_calendar/meal_calendar.dart';
import 'package:recipe_recommender_frontend/screens/search/search.dart';
import 'package:recipe_recommender_frontend/screens/settings/settings.dart';

class BottomNavView extends StatefulWidget {
  const BottomNavView({super.key});

  @override
  State<BottomNavView> createState() => _BottomNavViewState();
}

class _BottomNavViewState extends State<BottomNavView> {
  late PersistentTabController _controller;

  final List<Widget> _buildScreens = <Widget>[
    const Center(
      child: HomePage(),
    ),
    const Center(
      child: MealCalendar(),
    ),
    const Center(
      child: SearchPage(),
    ),
    const Center(
      child: FavoritesPage(),
    ),
    const Center(
      child: SettingsPage(),
    ),
  ];

  List<PersistentBottomNavBarItem> _navBarsItems() {
    return [
      PersistentBottomNavBarItem(
        inactiveColorPrimary: Colors.grey.shade400,
        iconSize: 20,
        icon: const Icon(
          CupertinoIcons.home,
        ),
        activeColorPrimary: Constants.primaryColor,
        title: ("Home"),
      ),
      PersistentBottomNavBarItem(
        inactiveColorPrimary: Colors.grey.shade400,
        iconSize: 20,
        icon: const Icon(
          CupertinoIcons.calendar,
        ),
        activeColorPrimary: Constants.primaryColor,
        title: ("Meal Calendar"),
      ),
      PersistentBottomNavBarItem(
        inactiveColorPrimary: Colors.grey.shade400,
        iconSize: 20,
        icon: const Icon(
          CupertinoIcons.search,
        ),
        activeColorPrimary: Constants.primaryColor,
        title: ("Search"),
      ),
      PersistentBottomNavBarItem(
        inactiveColorPrimary: Colors.grey.shade400,
        icon: const Icon(
          CupertinoIcons.heart_fill,
        ),
        iconSize: 20,
        activeColorPrimary: Constants.primaryColor,
        title: ("Favorite"),
      ),
      PersistentBottomNavBarItem(
        inactiveColorPrimary: Colors.grey.shade400,
        icon: const Icon(
          Icons.settings,
        ),
        iconSize: 20,
        activeColorPrimary: Constants.primaryColor,
        title: ("Settings"),
      ),
    ];
  }

  @override
  void initState() {
    _controller = PersistentTabController(initialIndex: 0);
    // TODO: implement initState
    super.initState();
  }

  @override
  void dispose() {
    _controller.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      
      child: PersistentTabView(
        this.context,
        controller: _controller,
        screens: _buildScreens,
        items: _navBarsItems(),
        confineInSafeArea: true,
        backgroundColor: Constants.secondaryColor,
        decoration: const NavBarDecoration(
          boxShadow: [
            //BoxShadow
            BoxShadow(
              color: Colors.grey,
              offset: Offset(0.0, -1.0),
              blurRadius: 20.0,
              spreadRadius: -5.0,
            ), //BoxShadow
          ],
          borderRadius: BorderRadius.only(
            topLeft: Radius.circular(20),
            topRight: Radius.circular(20),
          ),
        ),
        handleAndroidBackButtonPress: true,
        resizeToAvoidBottomInset: true,
        hideNavigationBarWhenKeyboardShows: true,
        popAllScreensOnTapOfSelectedTab: true,
        navBarStyle: NavBarStyle.style13,
      )
    
    );
  }
}
