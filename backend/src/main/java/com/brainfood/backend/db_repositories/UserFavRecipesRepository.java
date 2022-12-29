package com.brainfood.backend.db_repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainfood.backend.db_entities.RecipeDB;
import com.brainfood.backend.db_entities.UserFavRecipes;
import com.brainfood.backend.db_entities.UserFavRecipesCK;

public interface UserFavRecipesRepository extends JpaRepository<UserFavRecipes, UserFavRecipesCK> {
    
}
