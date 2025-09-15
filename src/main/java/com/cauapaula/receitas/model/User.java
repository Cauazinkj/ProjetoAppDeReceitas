package com.cauapaula.receitas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//lambok faz os getters e setters

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome", nullable = false)
    private String nome;

    @Column (unique = true, nullable = false)
    private String email;

    @Column (name = "senha", nullable = false)
    private String senha;

}
