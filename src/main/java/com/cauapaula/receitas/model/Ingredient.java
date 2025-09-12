package com.cauapaula.receitas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//lambok faz os getters e setters

@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

}
