package MAMALY.Repositories;
import MAMALY.DatabaseEntities.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> { }
