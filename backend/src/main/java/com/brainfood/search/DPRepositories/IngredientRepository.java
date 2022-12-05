package com.brainfood.search.DPRepositories;

import com.brainfood.search.DBEntities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
