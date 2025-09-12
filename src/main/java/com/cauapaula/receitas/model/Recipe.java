package com.cauapaula.receitas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//lambok faz os getters e setters

@Getter
@Setter
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "titulo")
    private String titulo;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "categoria")
    private String categoria;

    @Column(name = "tempo_preparo")
    private Integer tempoDePreparo;

    @Column(name = "imagem_url")
    private String imagemUrl;

}
