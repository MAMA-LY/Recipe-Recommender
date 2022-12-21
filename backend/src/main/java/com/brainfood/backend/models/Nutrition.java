package com.brainfood.backend.models;


import lombok.*;

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
