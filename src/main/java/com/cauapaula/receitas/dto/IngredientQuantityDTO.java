package com.cauapaula.receitas.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class IngredientQuantityDTO {
    private String ingredienteNome;
    private String quantidade;
}
