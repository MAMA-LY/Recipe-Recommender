import 'dart:math';

import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/models/daily_calories.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

class CaloriesView extends StatefulWidget {
  List<ChartData>? data;
  DailyCalories dailyCalories;
  final TooltipBehavior tooltip = TooltipBehavior(enable: true);

  CaloriesView({
    super.key,
    required this.dailyCalories,
  });

  @override
  State<CaloriesView> createState() => _CaloriesViewState();
}

class _CaloriesViewState extends State<CaloriesView> {

  @override
  void initState() {
    int remaining = max(widget.dailyCalories.remaining, 0);
    widget.data = [
      ChartData(
          'Fats',
          widget.dailyCalories.fats * 9
        ),
      ChartData(
          'Proteins',
          widget.dailyCalories.proteins * 4
        ),
      ChartData(
          'Carbs',
          widget.dailyCalories.carbs * 4
        ),
      ChartData(
        'Remaining',
         remaining
      )
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
                "Calories: ${widget.dailyCalories.calories} kcal",
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
                  )
            ]));
  }
}

class ChartData {
  ChartData(this.x, this.y);

  final String x;
  final int y;
}
