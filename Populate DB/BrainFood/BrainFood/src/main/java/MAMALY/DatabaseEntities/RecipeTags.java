package MAMALY.DatabaseEntities;

import lombok.Builder;
import javax.persistence.Entity;

@Entity
@Builder
public class RecipeTags {
    private String recipeID;
    private String tag;
}
