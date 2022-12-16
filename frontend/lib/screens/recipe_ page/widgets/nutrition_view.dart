import 'package:flutter/cupertino.dart';
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

class _NutritionViewState extends State<NutritionView>  {
  @override
  void initState(){
    super.initState();
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SfCircularChart(
            tooltipBehavior: widget.tooltip,
            series: <CircularSeries<ChartData, String>>[
              DoughnutSeries<ChartData, String>(
                  dataSource: widget.data = [
                    ChartData('Fats', widget.nutrition.fats),
                    ChartData('Proteins', widget.nutrition.proteins),
                    ChartData('Carbs', widget.nutrition.carbs),
                    ChartData('Calories', widget.nutrition.calories)
                  ],
                  xValueMapper: (ChartData data, _) => data.x,
                  yValueMapper: (ChartData data, _) => data.y,
                  dataLabelMapper: (ChartData data, _) => "${data.x}: ${data.y}%",
                  dataLabelSettings: const DataLabelSettings(isVisible: true),
                  name: 'Gold')
            ]));
  }
}

class ChartData {
  ChartData(this.x, this.y);
  final String x;
  final int y;
}