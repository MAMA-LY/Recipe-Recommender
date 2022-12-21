package com.brainfood.search.DPRepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brainfood.search.DBEntities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {
    @Query("select r from Recipe r where lower(r.name) like lower(:name)")
    List<Recipe> findByName(@Param("name") String name);

    Recipe findByNameEquals(String name);

    @Query("select r from Recipe r JOIN r.recipeIngredients ri JOIN ri.compositeKey.ingredientID i where lower(i.name) like lower(:name)")
    List<Recipe> findByIngredientsLike(@Param("name") String name);

    Recipe findByIdEquals(@Param("id") String id);
}
