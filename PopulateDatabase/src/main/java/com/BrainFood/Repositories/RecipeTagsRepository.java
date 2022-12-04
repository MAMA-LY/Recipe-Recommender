package com.BrainFood.Repositories;

import com.BrainFood.DatabaseEntities.RecipeTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTagsRepository extends JpaRepository<RecipeTags, Integer> { }
