class BodyInfo {
  double? height;
  double? weight;
  int? age;

  BodyInfo({this.height, this.weight, this.age});

  factory BodyInfo.fromJson(dynamic json) {
    return BodyInfo(
        height: json['height'] as double,
        weight: json['weight'] as double,
        age: json['age'] as int);
  }

  @override
  String toString() {
    return 'Recipe {height: $height, weight: $weight, age: $age}';
  }
}
