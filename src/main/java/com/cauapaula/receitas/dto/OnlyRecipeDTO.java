package com.cauapaula.receitas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnlyRecipeDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
    private String tempoDePreparo;
    private String imagemUrl;

    public OnlyRecipeDTO(Long id, String nome, String descricao,
                         String categoria, String tempoDePreparo,
                         String imagemUrl)  {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tempoDePreparo = tempoDePreparo;
        this.imagemUrl = imagemUrl;
    }

}
