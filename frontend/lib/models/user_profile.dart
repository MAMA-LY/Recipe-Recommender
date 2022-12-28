class UserProfile {
  final String username;

  final String email;

  final float height;

  final float weight;

  final Date birthdate;

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
        height: json['height'] as float,
        weight: json['weight'] as float,
        birthdate: json['birthdate'] as Date);
  }

  @override
  String toString() {
    return 'UserProfile {username: $username, email: $email, height: $height, weight: $weight, birthdate: $birthdate}';
  }
}