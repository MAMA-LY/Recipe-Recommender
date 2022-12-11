package com.brainfood.backend;
import lombok.Getter;
import lombok.Setter;

import java.awt.Image;

@Getter @Setter
public class Ingredient {

    private String name;
    

    private String ID;

    private Image icon ;

    private int weight;

    private Nutritions nutritions;
    
    
}
