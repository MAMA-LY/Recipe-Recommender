class UserProfile {
  final String username;

  final String email;

  final double height;

  final double weight;

  final String birthdate;

  final String gender;

  UserProfile(
      {required this.username,
        required this.email,
        required this.height,
        required this.weight,
        required this.birthdate,
        required this.gender});

  factory UserProfile.fromJson(dynamic json) {
    return UserProfile(
        username: json['username'] as String,
        email: json['email'] as String,
        height: json['height'],
        weight: json['weight'],
        birthdate: json['birthdate'] as String,
        gender: json['gender'] as String);
  }

  @override
  String toString() {
    return 'UserProfile {username: $username, email: $email, height: $height, weight: $weight, birthdate: $birthdate, gender: $gender}';
  }
}