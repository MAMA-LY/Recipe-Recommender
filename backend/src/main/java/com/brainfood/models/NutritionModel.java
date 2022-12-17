package com.brainfood.models;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NutritionModel {

    private int calories;

    private int proteins;

    private int carbs;

    private int fats;

}
