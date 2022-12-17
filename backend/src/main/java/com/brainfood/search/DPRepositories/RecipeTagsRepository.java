package com.brainfood.search.DPRepositories;

import com.brainfood.search.DBEntities.RecipeTags;
import com.brainfood.search.DBEntities.RecipeTagsCK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTagsRepository extends JpaRepository<RecipeTags, RecipeTagsCK> {
}