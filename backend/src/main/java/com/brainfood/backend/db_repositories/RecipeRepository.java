package com.brainfood.backend.db_repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brainfood.backend.db_entities.Ingredient;
import com.brainfood.backend.db_entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {
    @Query("select r from Recipe r " +
            "where lower(r.name) like lower(:name)")
    List<Recipe> findByName(@Param("name") String name);

    Recipe findByIdEquals(@Param("id") String id);

    @Query("select r from Recipe r " +
            "order by RANDOM()")
    List<Recipe> randomRecipes(Pageable pageable);

    @Query("select r, i.id, i.name from Recipe r " +
            "JOIN RecipeIngredients ri on ri.compositeKey.recipeID = r.id " +
            "JOIN Ingredient i on ri.compositeKey.ingredientID = i.id " +
            "where lower(i.name) like lower(:name)")
    List<Recipe> findByIngredientsLike(@Param("name") String name);

    @Query("select r from Recipe r " +
            "join RecipeIngredients ri on ri.compositeKey.recipeID = r.id " +
            "join Ingredient i on ri.compositeKey.ingredientID = i.id " +
            "where lower(i.name) like lower(:name) and r in (:exist)")
    List<Recipe> findByRecipeIngredientsIsLikeAndIdInList(@Param("name") String ingredient,
            @Param("exist") List<Recipe> exist);

    @Query("select r from Recipe r " +
            "join RecipeTags rt on rt.compositeKey.recipeID = r.id " +
            "where lower(rt.compositeKey.tag) = lower(:tag)")
    List<Recipe> findRecipeByTag(@Param("tag") String tag);

    @Query("select r from Recipe r " +
            "join RecipeTags rt on rt.compositeKey.recipeID = r.id " +
            "where lower(rt.compositeKey.tag) = lower(:tag) and r in (:exist)")
    List<Recipe> findRecipeByTagAndIdInList(@Param("tag") String tag, @Param("exist") List<Recipe> exist);

    @Query("select i from Recipe r " +
            "join RecipeIngredients ri on r.id = ri.compositeKey.recipeID " +
            "join Ingredient i on ri.compositeKey.ingredientID = i.id " +
            "where r.id = :id")
    List<Ingredient> findIngredientsByIdEquals(@Param("id") String id);

    @Query("select rt.compositeKey.tag from RecipeTags rt " +
            "join Recipe r on r.id = rt.compositeKey.recipeID " +
            "where r.id = :id")
    List<String> findTagsByIdEquals(@Param("id") String id);

}