package com.cauapaula.receitas.repository;

import com.cauapaula.receitas.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {
    Optional<Ingredient> findByNameIgnoreCase(String name);
}

