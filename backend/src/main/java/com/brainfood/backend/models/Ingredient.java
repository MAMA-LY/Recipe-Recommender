package com.brainfood.backend.models;

import lombok.*;

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
