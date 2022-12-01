package com.BrainFood.Repositories;

import com.BrainFood.DatabaseEntities.RecipeTags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTagsRepository extends CrudRepository<RecipeTags, Integer> { }
