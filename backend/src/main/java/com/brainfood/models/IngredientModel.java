package com.brainfood.models;
import lombok.*;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class IngredientModel {

    private String name;

    private String ID;

    private String icon ;

    private String amount;

    private NutritionModel nutritionModel;

    
    
}
