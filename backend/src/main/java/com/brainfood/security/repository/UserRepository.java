package com.brainfood.security.repository;


import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.security.model.User;
import com.brainfood.security.model.UserFavRecipes;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    User findByID(@Param("id") String id);



    @Query("select r from UserFavRecipes uf " +
            "join RecipeDB r on r.id = uf.compositeKey.recipeID " + 
            "where uf.compositeKey.userID = :id")
    Set<RecipeDB> findFavRecipesById(@Param("id") String id);
}
