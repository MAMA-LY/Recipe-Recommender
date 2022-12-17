package com.brainfood.backend.db_repositories;

import com.brainfood.backend.db_entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {
    List<Recipe> findByName(String name);

    List<Recipe> findByNameContaining(String name);

    /*@Query("select r, i.id, i.name from Recipe r " +
            "JOIN RecipeIngredients ri on ri.compositeKey.recipeID = r.id " +
            "JOIN Ingredient i on ri.compositeKey.ingredientID = i.id " +
            "where i.name like :name")
    List<Recipe> findByIngredientsLike(@Param("name") String name);*/

    Recipe findRecipeById(@Param("id") String id);
}
