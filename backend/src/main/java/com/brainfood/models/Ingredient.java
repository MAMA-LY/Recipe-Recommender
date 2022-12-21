package com.brainfood.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    private String name;

    private String ID;

    private String icon;

    private String amount;

    private Nutrition nutrition;

}
