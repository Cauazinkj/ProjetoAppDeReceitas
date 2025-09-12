package com.cauapaula.receitas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//lambok faz os getters e setters

@Getter
@Setter
@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredient {

    @EmbeddedId
    private RecipeIngredientId id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "quantidade", nullable = false)
    private String quantidade;

}
