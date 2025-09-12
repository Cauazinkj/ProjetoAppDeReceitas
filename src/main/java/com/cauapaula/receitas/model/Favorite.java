package com.cauapaula.receitas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//lambok faz os getters e setters

@Getter
@Setter
@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;



}
