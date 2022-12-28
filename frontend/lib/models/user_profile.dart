import 'dart:ffi';

class UserProfile {
  final String username;

  final String email;

  final Double height;

  final Double weight;

  final String birthdate;

  UserProfile(
      {required this.username,
        required this.email,
        required this.height,
        required this.weight,
        required this.birthdate});

  factory UserProfile.fromJson(dynamic json) {
    return UserProfile(
        username: json['username'] as String,
        email: json['email'] as String,
        height: json['height'] as Double,
        weight: json['weight'] as Double,
        birthdate: json['birthdate'] as String);
  }

  @override
  String toString() {
    return 'UserProfile {username: $username, email: $email, height: $height, weight: $weight, birthdate: $birthdate}';
  }
}