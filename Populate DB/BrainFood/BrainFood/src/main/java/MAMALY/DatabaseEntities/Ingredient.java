package MAMALY.DatabaseEntities;

import lombok.Builder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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