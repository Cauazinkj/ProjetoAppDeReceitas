package com.cauapaula.receitas.repository;

import com.cauapaula.receitas.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipeId(Long recipeId);
}
