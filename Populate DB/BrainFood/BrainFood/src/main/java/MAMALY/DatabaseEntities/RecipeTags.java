package MAMALY.DatabaseEntities;

import lombok.Builder;
import jakarta.persistence.Entity;

@Entity
@Builder
public class RecipeTags {
    private String recipeID;
    private String tag;
}
