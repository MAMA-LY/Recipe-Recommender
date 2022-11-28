package MAMALY.Repositories;

import MAMALY.DatabaseEntities.RecipeIngredients;
import MAMALY.DatabaseEntities.RecipeTags;
import org.springframework.data.repository.CrudRepository;

public interface RecipeTagsRepository extends CrudRepository<RecipeTags, Integer> { }
