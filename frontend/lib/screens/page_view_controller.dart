
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/screens/favorites.dart';
import 'package:recipe_recommender_frontend/screens/home.dart';
import 'package:recipe_recommender_frontend/screens/meal_calendar.dart';
import 'package:recipe_recommender_frontend/screens/search_page/search.dart';
import 'package:recipe_recommender_frontend/screens/settings.dart';

class PageViewController extends StatefulWidget {
  const PageViewController({super.key});

  @override
  State<PageViewController> createState() => _PageViewControllerState();
}

class _PageViewControllerState extends State<PageViewController> {
  late PageController _controller;
  int _currentIndex = 0;

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

  List<BottomNavigationBarItem> _navBarsItems() {
    return [
      const BottomNavigationBarItem(
        icon: Icon(
          CupertinoIcons.home,
        ),
        label: ("Home"),
      ),
      const BottomNavigationBarItem(
        icon: Icon(
          CupertinoIcons.calendar,
        ),
        label: ("Meal Calendar"),
      ),
      const BottomNavigationBarItem(
        icon: Icon(
          CupertinoIcons.search,
        ),
        label: ("Search"),
      ),
      const BottomNavigationBarItem(
        icon: Icon(
          CupertinoIcons.heart_fill,
        ),
        label: ("Favorite"),
      ),
      const BottomNavigationBarItem(
        icon: Icon(
          Icons.settings,
        ),
        label: ("Settings"),
      ),
    ];
  }

  @override
  void initState() {
    _controller = PageController(initialPage: 0);
    super.initState();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: PageView(
        controller: _controller,
        onPageChanged: (newIndex) {
          setState(() {
            _currentIndex = newIndex;
          });
        },
        children: _buildScreens,
      ),
      bottomNavigationBar: BottomNavigationBar(
        iconSize: 18,
        selectedFontSize: 10,
        selectedIconTheme: const IconThemeData(color: Constants.primaryColor, size: 25),
        selectedItemColor: Constants.primaryColor,
        selectedLabelStyle: const TextStyle(fontWeight: FontWeight.bold),
        unselectedItemColor: Colors.black45,
        currentIndex: _currentIndex,
        items: _navBarsItems(),
        onTap: (index) {
          setState(() {
            _controller.animateToPage(index,
                duration: const Duration(microseconds: 300), curve: Curves.ease);
          });
        },
      ),
    );
  }
}

