package com.cauapaula.receitas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ApiResponse {
    private String message;
    private boolean success;

    public ApiResponse() {}

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
