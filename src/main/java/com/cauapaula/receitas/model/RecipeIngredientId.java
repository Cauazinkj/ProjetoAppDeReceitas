package com.cauapaula.receitas.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeIngredientId implements Serializable {
    private Long recipeId;
    private Long ingredientId;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof RecipeIngredientId)) return false;
        RecipeIngredientId that = (RecipeIngredientId) o;
        return Objects.equals(recipeId, that.recipeId) &&
                Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(recipeId, ingredientId);
    }

}
