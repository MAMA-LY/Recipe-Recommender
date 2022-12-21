package com.brainfood.backend.db_repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainfood.backend.db_entities.RecipeTags;
import com.brainfood.backend.db_entities.RecipeTagsCK;

@Repository
public interface RecipeTagsRepository extends JpaRepository<RecipeTags, RecipeTagsCK> {
}