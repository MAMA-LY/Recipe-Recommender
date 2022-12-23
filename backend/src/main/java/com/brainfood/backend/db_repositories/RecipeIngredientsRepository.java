package com.brainfood.backend.db_repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainfood.backend.db_entities.RecipeIngredients;
import com.brainfood.backend.db_entities.RecipeIngredientsCK;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, RecipeIngredientsCK> {
}