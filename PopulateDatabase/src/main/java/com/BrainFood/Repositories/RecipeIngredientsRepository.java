package com.BrainFood.Repositories;

import com.BrainFood.DatabaseEntities.RecipeIngredients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientsRepository extends CrudRepository<RecipeIngredients, Integer> { }
