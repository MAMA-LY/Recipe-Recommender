package com.BrainFood.Repositories;
import com.BrainFood.DatabaseEntities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> { }