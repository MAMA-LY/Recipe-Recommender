<<<<<<< HEAD

=======
>>>>>>> main
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

<<<<<<< HEAD
=======
import '../../../constants.dart';

>>>>>>> main
class NutritionView extends StatefulWidget {
  late List<ChartData> data;
  late Nutrition nutrition;
  final TooltipBehavior tooltip = TooltipBehavior(enable: true);

  NutritionView({
    super.key,
    required this.nutrition,
<<<<<<< HEAD
    });
  
@override
  State<NutritionView> createState() => _NutritionViewState();
}

class _NutritionViewState extends State<NutritionView>  {
  @override
  void initState(){
    widget.data = [
                    ChartData('Fats', widget.nutrition.fats / (widget.nutrition.fats + widget.nutrition.proteins + widget.nutrition.carbs + 10) * 100),
                    ChartData('Proteins', widget.nutrition.proteins / (widget.nutrition.fats + widget.nutrition.proteins + widget.nutrition.carbs + 10)* 100),
                    ChartData('Carbs', widget.nutrition.carbs / (widget.nutrition.fats + widget.nutrition.proteins + widget.nutrition.carbs + 10) * 100),
                  ];
    widget.data.add(ChartData('Others', (10/ (widget.nutrition.fats + widget.nutrition.proteins + widget.nutrition.carbs + 10) * 100)));
    super.initState();
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SfCircularChart(
            annotations: [
                    CircularChartAnnotation(
                      widget: Text(
                        "Calories: ${widget.nutrition.calories} kcal",
                        style: Theme.of(context).textTheme.caption,
                      )
                    )
                  ],
=======
  });

  @override
  State<NutritionView> createState() => _NutritionViewState();
}

class _NutritionViewState extends State<NutritionView> {
  @override
  void initState() {
    widget.data = [
      ChartData(
          'Fats',
          widget.nutrition.fats /
              (widget.nutrition.fats +
                  widget.nutrition.proteins +
                  widget.nutrition.carbs) *
              100),
      ChartData(
          'Proteins',
          widget.nutrition.proteins /
              (widget.nutrition.fats +
                  widget.nutrition.proteins +
                  widget.nutrition.carbs) *
              100),
      ChartData(
          'Carbs',
          widget.nutrition.carbs /
              (widget.nutrition.fats +
                  widget.nutrition.proteins +
                  widget.nutrition.carbs) *
              100),
    ];

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Constants.secondaryColor,
        body: SfCircularChart(
            annotations: [
              CircularChartAnnotation(
                  widget: Text(
                "Calories: ${widget.nutrition.calories} kcal",
                style: Theme.of(context).textTheme.caption,
              ))
            ],
>>>>>>> main
            tooltipBehavior: widget.tooltip,
            legend: Legend(isVisible: true),
            series: <DoughnutSeries<ChartData, String>>[
              DoughnutSeries<ChartData, String>(
                  radius: '80%',
                  innerRadius: '65%',
                  explode: true,
                  explodeOffset: '10%',
                  dataSource: widget.data,
                  xValueMapper: (ChartData data, _) => data.x,
                  yValueMapper: (ChartData data, _) => data.y,
<<<<<<< HEAD
                  dataLabelMapper: (ChartData data, _) => "${data.x} ${data.y}%",
                  dataLabelSettings: const DataLabelSettings(isVisible: false, textStyle: TextStyle(fontFamily:"Roboto", fontStyle: FontStyle.normal)),
=======
                  dataLabelMapper: (ChartData data, _) =>
                      "${data.x} ${data.y}%",
                  dataLabelSettings: const DataLabelSettings(
                      isVisible: false,
                      textStyle: TextStyle(
                          fontFamily: "Roboto", fontStyle: FontStyle.normal)),
>>>>>>> main
                  name: 'Percentage')
            ]));
  }
}

class ChartData {
  ChartData(this.x, this.y);
<<<<<<< HEAD
  final String x;
  final double y;
}
=======

  final String x;
  final double y;
}
>>>>>>> main
