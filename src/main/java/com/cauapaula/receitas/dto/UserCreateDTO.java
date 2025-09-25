package com.cauapaula.receitas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {
    private String nome;
    private String email;
    private String password;
}
