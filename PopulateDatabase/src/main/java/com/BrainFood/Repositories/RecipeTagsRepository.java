package com.BrainFood.Repositories;

import com.BrainFood.DatabaseEntities.RecipeIngredients;
import com.BrainFood.DatabaseEntities.RecipeTags;
import org.springframework.data.repository.CrudRepository;

public interface RecipeTagsRepository extends CrudRepository<RecipeTags, Integer> { }
