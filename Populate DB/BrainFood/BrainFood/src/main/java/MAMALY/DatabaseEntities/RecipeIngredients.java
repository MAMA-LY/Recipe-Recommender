package MAMALY.DatabaseEntities;

import lombok.Builder;
import javax.persistence.Entity;

@Entity
@Builder
public class RecipeIngredients {
    private String recipeID;

    private String ingredientID;
}
