package com.cauapaula.receitas.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter

public class RecipeCreateDTO {
    private String titulo;
    private String descricao;
    private UUID userId; // user é Long
    private String categoria;
    private Integer tempoDePreparo;
    private String imagemUrl;
    private List<IngredientQuantityDTO> ingredientes;
}

