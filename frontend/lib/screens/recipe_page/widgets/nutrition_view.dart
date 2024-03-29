import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

class NutritionView extends StatefulWidget {
  late List<ChartData> data;
  late Nutrition nutrition;
  final TooltipBehavior tooltip = TooltipBehavior(enable: true);

  NutritionView({
    super.key,
    required this.nutrition,
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
        backgroundColor: Theme.of(context).secondaryHeaderColor,
        body: SfCircularChart(
            annotations: [
              CircularChartAnnotation(
                  widget: Text(
                softWrap: true,
                "Calories: ${widget.nutrition.calories} kcal",
                style: TextStyle(
                    fontSize: 13, color: Theme.of(context).focusColor),
              ))
            ],
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
                  dataLabelMapper: (ChartData data, _) =>
                      "${data.x} ${data.y}%",
                  dataLabelSettings: const DataLabelSettings(
                      isVisible: false,
                      textStyle: TextStyle(
                          fontFamily: "Roboto", fontStyle: FontStyle.normal)),
                  name: 'Percentage')
            ]));
  }
}

class ChartData {
  ChartData(this.x, this.y);

  final String x;
  final double y;
}
