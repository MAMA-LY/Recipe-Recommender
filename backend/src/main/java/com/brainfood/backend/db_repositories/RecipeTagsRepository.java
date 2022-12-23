package com.brainfood.backend.db_repositories;

import com.brainfood.backend.db_entities.RecipeTags;
import com.brainfood.backend.db_entities.RecipeTagsCK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTagsRepository extends JpaRepository<RecipeTags, RecipeTagsCK> {
}