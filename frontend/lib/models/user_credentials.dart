class UserCredentials {
  final String ID;
  final String email;
  final String password;

  UserCredentials(
      {required this.ID,
        required this.email,
        required this.password});

  factory UserCredentials.fromJson(dynamic json) {
    return UserCredentials(
        ID: json['ID'] as String,
        email: json['email'] as String,
        password: json['password'] as String);
  }

  @override
  String toString() {
    return 'Recipe {ID: $ID, email: $email, password: $password}';
  }
}