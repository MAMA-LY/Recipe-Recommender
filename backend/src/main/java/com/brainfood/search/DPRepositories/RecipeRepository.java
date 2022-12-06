package com.brainfood.search.DPRepositories;

import com.brainfood.search.DBEntities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {
    @Query("select r from Recipe r where lower(r.name) like lower(:name)")
    List<Recipe> findByName(@Param("name") String name);

    @Query("select r from Recipe r JOIN r.recipeIngredients ri JOIN ri.compositeKey.ingredientID i where lower(i.name) like lower(:name)")
    List<Recipe> findByIngredientsLike(@Param("name") String name);
}
