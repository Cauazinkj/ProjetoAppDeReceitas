package com.cauapaula.receitas.service;

import com.cauapaula.receitas.dto.OnlyRecipeDTO;
import com.cauapaula.receitas.model.Recipe;
import com.cauapaula.receitas.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> listarTodas(){
        return recipeRepository.findAll();
    }

    public Optional<Recipe> buscarPorId(Long id){
        return recipeRepository.findById(id);
    }

    public Recipe salvar(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public void deletarPorId(Long id){
        recipeRepository.deleteById(id);
    }

    public Recipe atualizar(Long id, Recipe recipeAtualizada){
        return recipeRepository.findById(id)
                .map(recipe -> {

                    if(recipe.getTitulo() != null){
                        recipe.setTitulo(recipeAtualizada.getTitulo());
                    }
                    if(recipe.getDescricao() != null){
                        recipe.setDescricao(recipeAtualizada.getDescricao());
                    }
                    if(recipe.getCategoria() != null){
                        recipe.setCategoria(recipeAtualizada.getCategoria());
                    }
                    if(recipe.getTempoDePreparo() != null){
                        recipe.setTempoDePreparo(recipeAtualizada.getTempoDePreparo());
                    }
                    if(recipe.getImagemUrl() != null){
                        recipe.setImagemUrl(recipeAtualizada.getImagemUrl());
                    }

                    return recipeRepository.save(recipe);
                }).orElseThrow(() -> new RuntimeException("Receita não encontrada"));
    }

}
