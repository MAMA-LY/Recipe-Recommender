import 'body_info.dart';
import 'calendar.dart';
import 'recipe.dart';
import 'user_credentials.dart';

class Profile {
  final UserCredentials userCredentials;

  List<Recipe>? favoriteRecipes;
  String? photo;

  String? name;
  int? dailyCalories;
  int? caloriesDate;
  BodyInfo? bodyInfo;
  Calendar? calendar;

  Profile(
      {required this.userCredentials,
        required this.favoriteRecipes,
        required this.photo,
        required this.name,
        required this.dailyCalories,
        required this.caloriesDate,
        required this.bodyInfo,
        required this.calendar});

  factory Profile.fromJson(dynamic json) {
    return Profile(
        userCredentials: json['userCredentials'] as UserCredentials,
        favoriteRecipes: json['favoriteRecipes'] as List<Recipe>,
        photo: json['photo'] as String,
        name: json['name'] as String,
        dailyCalories: json['dailyCalories'] as int,
        caloriesDate: json['caloriesDate'] as int,
        bodyInfo: json['bodyInfo'] as BodyInfo,
        calendar: json['calendar'] as Calendar,);
  }

  @override
  String toString() {
    return 'Recipe {userCredentials: $userCredentials, favoriteRecipes: $favoriteRecipes, photo: $photo, name: $name,'
        ' dailyCalories: $dailyCalories, caloriesDate: $caloriesDate, bodyInfo: $bodyInfo, calendar: $calendar}';
  }
}
