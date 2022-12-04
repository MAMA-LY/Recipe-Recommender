package com.brainfood.search.DPRepositories;

import com.brainfood.search.DBEntities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

    @Query("select r1 from Recipe r1 where lower(r1.name) like lower(:name)")
    List<Recipe> findByName(@Param("name") String name);
}
