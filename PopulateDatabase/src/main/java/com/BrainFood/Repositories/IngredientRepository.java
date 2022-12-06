package com.BrainFood.Repositories;

import com.BrainFood.DatabaseEntities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    boolean existsIngredientByName(String name);

}