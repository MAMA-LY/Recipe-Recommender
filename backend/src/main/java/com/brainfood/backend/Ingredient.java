package com.brainfood.backend;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.Image;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Ingredient {

    private String name;

    private String ID;

    private Image icon ;

    private int weight;

    private Nutrition nutrition;
    
    
}
