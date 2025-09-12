package com.cauapaula.receitas.repository;

import com.cauapaula.receitas.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByRecipeId(Long recipeId);
}

