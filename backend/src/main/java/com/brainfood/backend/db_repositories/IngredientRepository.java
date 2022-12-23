package com.brainfood.backend.db_repositories;

import com.brainfood.backend.db_entities.IngredientDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientDB, String> {
    @Query("SELECT distinct i.name FROM IngredientDB i")
    List<String> getDistinctByName();
}
