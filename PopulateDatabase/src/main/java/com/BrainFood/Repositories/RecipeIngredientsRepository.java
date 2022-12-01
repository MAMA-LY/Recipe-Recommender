package com.BrainFood.Repositories;

import com.BrainFood.DatabaseEntities.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, Integer> { }
