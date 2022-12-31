import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/models/daily_calories.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:recipe_recommender_frontend/screens/calories_page/widgets/calories_view.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../../api/user_profile_api.dart';
import '../../main.dart';
import '../../models/user_profile.dart';

class CaloriesPage extends StatefulWidget {
  @override
  _CaloriesPageState createState() => _CaloriesPageState();
}
class _CaloriesPageState extends State<CaloriesPage> {
  DailyCalories dailyCalories = DailyCalories(calories: 0, proteins: 0, carbs: 0, fats: 0, remaining: 0);
  CaloriesView? caloriesView;

  DailyCalories getDailyCalories(SharedPreferences prefs){
    String lastTrackedDate = prefs.getString("lastTrackedDate") ?? "Untracked";
    int estimatedCalories = prefs.getInt("estimatedCalories") ?? 0;
    int consumedCalories = prefs.getInt("consumedCalories") ?? 0;
    int consumedCarbs = prefs.getInt("consumedCarbs") ?? 0;
    int consumedProteins= prefs.getInt("consumedProteins") ?? 0;
    int consumedFats = prefs.getInt("consumedFats") ?? 0;
    debugPrint(consumedProteins.toString());
    DailyCalories dailyCalories = DailyCalories(calories: consumedCalories, proteins: consumedProteins, carbs: consumedCarbs, fats: consumedFats, remaining: estimatedCalories - consumedCalories);
    debugPrint(dailyCalories.toString());
    return dailyCalories;
  }

  Future<SharedPreferences> getSharedPreference() async {
    await CalorieWatcher.validateDailyCalories();
    return SharedPreferences.getInstance();
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder<SharedPreferences>(
      future: getSharedPreference(),
      builder: ((context, snapshot) {
        if(snapshot.hasData){
          SharedPreferences prefs = snapshot.data!;
          dailyCalories = getDailyCalories(prefs);
          caloriesView = CaloriesView(dailyCalories: dailyCalories);
          return Scaffold(
            appBar: AppBar(
                title: const Text('Calories Watcher'),
                backgroundColor: Theme
                .of(context)
                .secondaryHeaderColor,
                // ignore: dead_code
                actions: [
                  IconButton(
                    icon: const Icon(
                      Icons.refresh,
                      color: Colors.black,
                    ),
                    onPressed: () async {
                      await CalorieWatcher.reset();
                      setState(() {
                        dailyCalories = getDailyCalories(prefs);
                        caloriesView = CaloriesView(dailyCalories: dailyCalories);
                      });
                    },
                  )
                ]),
            body: Center(
              child: caloriesView
              ),
            );
        } else {
          return const CircularProgressIndicator();
        }
      }
    )
  );
}
}

class CalorieWatcher{
  static Future<void> reset() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    await prefs.setString("lastTrackedDate", "Untracked");
    await prefs.reload();
    await validateDailyCalories();
  }

  static Future<void> validateDailyCalories() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    int estimatedCalories = prefs.getInt("estimatedCalories") ?? 0;
    int consumedCalories = prefs.getInt("consumedCalories") ?? 0;
    String lastTrackedDate = prefs.getString("lastTrackedDate") ?? "Untracked";
    
    if(lastTrackedDate == "Untracked" || DateTime.now().difference(DateTime.parse(lastTrackedDate)).inDays >= 1){
      UserProfileAPI profileAPI = UserProfileAPI.fromCookie(session.cookie);
      UserProfile profile = await profileAPI.getUserProfile();
      debugPrint(profile.toString());
      debugPrint(DateTime.parse(profile.birthdate).toString());
      double age = DateTime.now().difference(DateTime.parse(profile.birthdate)).inDays/365.25;
      double weight = profile.weight;
      double height = profile.height;
      int genderBias = (profile.birthdate == "male"? 5: -161);
      double BMR = 10 * weight + 6.25 * height + genderBias;
      double TDEE = BMR * 1.2;
      int consumableCalories = TDEE.round();
      debugPrint(consumableCalories.toString());
      await prefs.setInt("estimatedCalories", consumableCalories);
      await prefs.setInt("consumedCalories", 0);
      await prefs.setInt("consumedCarbs", 0);
      await prefs.setInt("consumedProteins", 0);
      await prefs.setInt("consumedFats", 0);
      await prefs.setString("lastTrackedDate", DateTime.now().toString());
      await prefs.reload();
    }
  }
}