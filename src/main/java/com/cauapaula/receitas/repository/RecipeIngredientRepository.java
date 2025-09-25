package com.cauapaula.receitas.repository;

import com.cauapaula.receitas.model.RecipeIngredient;
import com.cauapaula.receitas.model.RecipeIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientId> {

    List<RecipeIngredient> findByRecipe_Id(UUID recipeId);
}
