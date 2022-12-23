package com.brainfood.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Nutrition {

    private int calories;

    private int proteins;

    private int carbs;

    private int fats;

}
