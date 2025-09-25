package com.cauapaula.receitas.controller;

import com.cauapaula.receitas.dto.RecipeCreateDTO;
import com.cauapaula.receitas.model.Recipe;
import com.cauapaula.receitas.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    public ResponseEntity<Recipe> criarReceita(@RequestBody RecipeCreateDTO dto) {
        Recipe saved = recipeService.criarReceita(dto);
        return ResponseEntity.ok(saved);
    }

    // API para listar todas as receitas

    @Operation(
            summary = "Lista receitas completas",
            description = "Retorna todas as receitas e detalhes disponíveis"
    )
    @GetMapping
    public List<Recipe> listarTodos() {
        return recipeService.listarTodas();
    }

    // API para buscar por ID

    @Operation(
            summary = "Buscar por id",
            description = "Busca a receita e detalhes pelo id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable UUID id) {
        Recipe recipe = recipeService.buscarPorId(id);
        return ResponseEntity.ok(recipe);
    }

    // API para atualizar uma receita

    @Operation(
            summary = "Atualiza uma receita",
            description = "Atualiza a receita com base no id e nas informações entregues"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<?> atualizarReceita(
            @PathVariable UUID id,
            @RequestBody Recipe recipeAtualizada){
        try {
            Recipe updateRecipe = recipeService.atualizar(id, recipeAtualizada);
            return ResponseEntity.ok(updateRecipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // API de deletar receitas

    @Operation(
            summary = "Deleta uma receita",
            description = "Deleta uma receita com base no id"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarReceita(@PathVariable UUID id){
        recipeService.deletarPorId(id);
        return ResponseEntity.ok().build();
    }

}
