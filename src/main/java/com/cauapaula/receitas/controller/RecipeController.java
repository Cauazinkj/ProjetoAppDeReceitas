package com.cauapaula.receitas.controller;

import com.cauapaula.receitas.dto.OnlyRecipeDTO;
import com.cauapaula.receitas.model.Recipe;
import com.cauapaula.receitas.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/recipes")
@Tag(name = "Recipes", description = "Endpoint para gerenciamento de receitas")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    //API para listar todas as receitas

    @Operation(
            summary = "Lista receitas completas",
            description = "Retorna todas as receitas e detalhes disponíveis"
    )
    @GetMapping
    public List<OnlyRecipeDTO> listarTodos() {
        return recipeService.listarTodas();
    }

    //API para buscar por ID

    @Operation(
            summary = "Buscar por id",
            description = "Busca a receita e detalhes pelo id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> buscarPorId(@PathVariable Long id){
        return recipeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Api para criar uma receita

    @Operation(
            summary = "Criar receita",
            description = "Cria uma nova receita e suas informações pelo id"
    )
    @PostMapping("/{id}")
    public Recipe criarReceita(@RequestBody Recipe recipe){
        return recipeService.salvar(recipe);
    }

    //API para atualizar uma receita

    @Operation(
            summary = "Atualiza uma receita",
            description = "Atualiza a receita com base no id e nas informações entregues"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<?> atualizarReceita(
            @PathVariable Long id,
            @RequestBody Recipe recipeAtualizada){
        try{
            Recipe updateRecipe = recipeService.atualizar(id, recipeAtualizada);
            return ResponseEntity.ok(updateRecipe);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
