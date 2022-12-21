package com.brainfood.search.DPRepositories;

import com.brainfood.search.DBEntities.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, Integer> { }