package com.brainfood.backend.db_repositories;

import com.brainfood.backend.db_entities.IngredientDB;
import com.brainfood.backend.db_entities.RecipeDB;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeDB, String> {
    @Query("select r from RecipeDB r " +
            "where lower(r.name) like lower(:name)")
    List<RecipeDB> findByName(@Param("name") String name);

    RecipeDB findByIdEquals(@Param("id") String id);

    @Query("select r from RecipeDB r " +
            "order by RANDOM()")
    List<RecipeDB> randomRecipes(Pageable pageable);

    @Query("select r, i.id, i.name from RecipeDB r " +
            "JOIN RecipeIngredients ri on ri.compositeKey.recipeID = r.id " +
            "JOIN IngredientDB i on ri.compositeKey.ingredientID = i.id " +
            "where lower(i.name) like lower(:name)")
    List<RecipeDB> findByIngredientsLike(@Param("name") String name);

    @Query("select r from RecipeDB r " +
            "join RecipeIngredients ri on ri.compositeKey.recipeID = r.id " +
            "join IngredientDB i on ri.compositeKey.ingredientID = i.id " +
            "where lower(i.name) like lower(:name) and r in (:exist)")
    List<RecipeDB> findByRecipeIngredientsIsLikeAndIdInList(@Param("name") String ingredient,
                                                            @Param("exist") List<RecipeDB> exist);

    @Query("select r from RecipeDB r " +
            "join RecipeTags rt on rt.compositeKey.recipeID = r.id " +
            "where lower(rt.compositeKey.tag) = lower(:tag)")
    List<RecipeDB> findRecipeByTag(@Param("tag") String tag);

    @Query("select r from RecipeDB r " +
            "join RecipeTags rt on rt.compositeKey.recipeID = r.id " +
            "where lower(rt.compositeKey.tag) = lower(:tag) and r in (:exist)")
    List<RecipeDB> findRecipeByTagAndIdInList(@Param("tag") String tag, @Param("exist") List<RecipeDB> exist);

    @Query("select i from RecipeDB r " +
            "join RecipeIngredients ri on r.id = ri.compositeKey.recipeID " +
            "join IngredientDB i on ri.compositeKey.ingredientID = i.id " +
            "where r.id = :id")
    List<IngredientDB> findIngredientsByIdEquals(@Param("id") String id);

    @Query("select rt.compositeKey.tag from RecipeTags rt " +
            "join RecipeDB r on r.id = rt.compositeKey.recipeID " +
            "where r.id = :id")
    List<String> findTagsByIdEquals(@Param("id") String id);

}
