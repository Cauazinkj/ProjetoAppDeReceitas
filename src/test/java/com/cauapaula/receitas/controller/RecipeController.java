package com.cauapaula.receitas.controller;

import com.cauapaula.receitas.model.Recipe;
import com.cauapaula.receitas.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ApiResponse(responseCode = "200", description = "Lista de receitas retornada")
    @GetMapping
    public List<Recipe> listarTodas(){
        return recipeService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> buscarPorId(@PathVariable Long id){
        return recipeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
