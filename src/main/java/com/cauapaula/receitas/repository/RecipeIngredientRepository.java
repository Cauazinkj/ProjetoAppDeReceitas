package com.cauapaula.receitas.repository;

import com.cauapaula.receitas.model.RecipeIngredient;
import com.cauapaula.receitas.model.RecipeIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientId> {
    List<RecipeIngredient> findByRecipeId(Long recipeId); // aqui funciona, pois RecipeIngredientId tem recipeId
}
