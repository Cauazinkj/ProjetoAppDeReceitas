package com.cauapaula.receitas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class RecipeIngredientId implements Serializable {

    @Column(name = "recipe_id")
    private UUID recipeId;

    @Column(name = "ingredient_id")
    private UUID ingredientId;

    public RecipeIngredientId() {}

    public RecipeIngredientId(UUID recipeId, UUID ingredientId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    // getters e setters (pode usar Lombok se preferir)
    public UUID getRecipeId() { return recipeId; }
    public void setRecipeId(UUID recipeId) { this.recipeId = recipeId; }

    public UUID getIngredientId() { return ingredientId; }
    public void setIngredientId(UUID ingredientId) { this.ingredientId = ingredientId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredientId)) return false;
        RecipeIngredientId that = (RecipeIngredientId) o;
        return Objects.equals(recipeId, that.recipeId) &&
                Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, ingredientId);
    }
}
