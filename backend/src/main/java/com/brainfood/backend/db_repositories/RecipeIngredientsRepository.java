package com.brainfood.backend.db_repositories;

import com.brainfood.backend.db_entities.Ingredient;
import com.brainfood.backend.db_entities.Recipe;
import com.brainfood.backend.db_entities.RecipeIngredients;
import com.brainfood.backend.db_entities.RecipeIngredientsCK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, RecipeIngredientsCK> {

    public List<RecipeIngredients> findByRecipe(Recipe recipe);
    public List<RecipeIngredients> findByIngredient(Ingredient ingredient);

    public List<RecipeIngredients> findByIngredientName(String name);

    public List<RecipeIngredients> findByIngredientAmount(String amount);

    public List<RecipeIngredients> findByIngredientNameLike(String name);
}


