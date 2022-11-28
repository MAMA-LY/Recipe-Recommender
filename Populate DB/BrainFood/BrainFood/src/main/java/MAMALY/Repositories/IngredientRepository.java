package MAMALY.Repositories;
import MAMALY.DatabaseEntities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> { }