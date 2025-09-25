package com.cauapaula.receitas.controller;

import com.cauapaula.receitas.dto.UserCreateDTO;
import com.cauapaula.receitas.model.User;
import com.cauapaula.receitas.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "Novo usuario", description = "A API vai criar um novo usuario dentro do banco de dados")
    @PostMapping("/new")
    public ResponseEntity<User> criarUsuario(@RequestBody UserCreateDTO dto) {
        User user = userService.criarUsuario(dto);
        return ResponseEntity.ok(user);
    }
}
