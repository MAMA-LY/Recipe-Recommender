package MAMALY.DatabaseEntities;

import lombok.Builder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String ID;

    private String name;

    private String icon;

    private int calories;

    private int weight;

    private int proteins;

    private int fats;

    private String photo;







}