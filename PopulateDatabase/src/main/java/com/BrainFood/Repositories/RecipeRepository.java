package com.BrainFood.Repositories;

import com.BrainFood.DatabaseEntities.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> { }
