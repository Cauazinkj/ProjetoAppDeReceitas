package com.cauapaula.receitas.repository;

import com.cauapaula.receitas.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeInfredientRepository extends JpaRepository<RecipeIngredient, Long> {
    List<RecipeIngredient> findByRecipeId(Long recipeId);
}
