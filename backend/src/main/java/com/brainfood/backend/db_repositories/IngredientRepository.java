package com.brainfood.backend.db_repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brainfood.backend.db_entities.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {
    @Query("SELECT i from Ingredient i " +
            "JOIN RecipeIngredients ri ON ri.compositeKey.ingredientID = i.id " +
            "JOIN Recipe r on r.id = ri.compositeKey.recipeID" +
            " where r.id = :id")
    List<Ingredient> findIngredients(@Param("id") String id);
}
