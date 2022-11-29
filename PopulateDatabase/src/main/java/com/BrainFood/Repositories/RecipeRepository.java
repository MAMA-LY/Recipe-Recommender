package com.BrainFood.Repositories;
import com.BrainFood.DatabaseEntities.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> { }
