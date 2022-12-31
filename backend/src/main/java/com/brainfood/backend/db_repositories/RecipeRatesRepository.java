package com.brainfood.backend.db_repositories;

import com.brainfood.backend.db_entities.RecipeRatesCK;
import com.brainfood.backend.db_entities.RecipeRatesDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRatesRepository extends JpaRepository<RecipeRatesDB, RecipeRatesCK> {

    @Query("select r from RecipeRatesDB r " +
            "where r.compositeKey.recipeID = (:recipeID) and r.compositeKey.userID = (:userID)")
    RecipeRatesDB findRateForUser(@Param("recipeID") String recipeID, @Param("userID") String userID);
}
