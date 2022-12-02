package com.BrainFood.Repositories;

import com.BrainFood.DatabaseEntities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    boolean existsRecipeByName(String name);
}
