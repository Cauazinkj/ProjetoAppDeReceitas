package com.cauapaula.receitas.repository;

import com.cauapaula.receitas.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByRecipeId(Long recipeId);
}
