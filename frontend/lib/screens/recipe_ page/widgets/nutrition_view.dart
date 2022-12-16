import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/models/nutrition.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

class NutritionView extends StatelessWidget {

  late List<ChartData> data;
  late Nutrition nutrition;
  final TooltipBehavior tooltip = TooltipBehavior(enable: true);

  NutritionView({
    super.key,
    required this.nutrition,
    });
  
  
  void prepareNutritionToPlot() {
    data = [
      ChartData('Fats', nutrition.fats),
      ChartData('Proteins', nutrition.proteins),
      ChartData('Carbs', nutrition.carbs),
      ChartData('Calories', nutrition.calories)
    ];
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Syncfusion Flutter chart'),
        ),
        body: SfCircularChart(
            tooltipBehavior: tooltip,
            series: <CircularSeries<ChartData, String>>[
              DoughnutSeries<ChartData, String>(
                  dataSource: data,
                  xValueMapper: (ChartData data, _) => data.x,
                  yValueMapper: (ChartData data, _) => data.y,
                  name: 'Gold')
            ]));
  }
}
 
class ChartData {
  ChartData(this.x, this.y);
  final String x;
  final int y;
}