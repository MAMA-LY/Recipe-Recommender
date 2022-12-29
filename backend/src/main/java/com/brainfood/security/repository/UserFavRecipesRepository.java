package com.brainfood.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.security.model.UserFavRecipes;
import com.brainfood.security.model.UserFavRecipesCK;

public interface UserFavRecipesRepository extends JpaRepository<UserFavRecipes, UserFavRecipesCK> {
    
}
