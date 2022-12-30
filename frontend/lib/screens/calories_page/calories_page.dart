import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/models/daily_calories.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:recipe_recommender_frontend/screens/calories_page/widgets/calories_view.dart';
import 'package:shared_preferences/shared_preferences.dart';

class CaloriesPage extends StatefulWidget {
  @override
  _CaloriesPageState createState() => _CaloriesPageState();
}
class _CaloriesPageState extends State<CaloriesPage> {
  @override
  Widget build(BuildContext context) {
    return FutureBuilder<SharedPreferences>(
      future: SharedPreferences.getInstance(),
      builder: ((context, snapshot) {
        if(snapshot.hasData){
          SharedPreferences prefs = snapshot.data!;
          String lastTrackedDate = prefs.getString("lastTrackedDate") ?? "Untracked";
          int estimatedCalories = prefs.getInt("estimatedCalories") ?? 0;
          int consumedCalories = prefs.getInt("consumedCalories") ?? 0;
          int consumedCarbs = prefs.getInt("consumedCarbs") ?? 0;
          int consumedProteins= prefs.getInt("consumedProteins") ?? 0;
          int consumedFats = prefs.getInt("consumedFats") ?? 0;
          DailyCalories dailyCalories = DailyCalories(calories: consumedCalories, proteins: consumedProteins, carbs: consumedCarbs, fats: consumedFats, remaining: estimatedCalories - consumedCalories);
          debugPrint(dailyCalories.toString());
          return Scaffold(
            appBar: AppBar(
                title: const Text('Calories Watcher'),
                backgroundColor: Theme
                .of(context)
                .secondaryHeaderColor),
            body: Center(
              child: CaloriesView(dailyCalories: dailyCalories)
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