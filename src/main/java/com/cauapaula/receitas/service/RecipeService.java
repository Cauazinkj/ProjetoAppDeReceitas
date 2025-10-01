package com.cauapaula.receitas.service;

import com.cauapaula.receitas.dto.IngredientQuantityDTO;
import com.cauapaula.receitas.dto.RecipeCreateDTO;
import com.cauapaula.receitas.dto.RecipeStepDTO;
import com.cauapaula.receitas.model.*;
import com.cauapaula.receitas.repository.IngredientRepository;
import com.cauapaula.receitas.repository.RecipeRepository;
import com.cauapaula.receitas.repository.RecipeStepRepository;
import com.cauapaula.receitas.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;
    private final RecipeStepRepository recipeStepRepository;

    public RecipeService(RecipeRepository recipeRepository,
                         IngredientRepository ingredientRepository,
                         UserRepository userRepository,
                         RecipeStepRepository recipeStepRepository) {

        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.userRepository = userRepository;
        this.recipeStepRepository = recipeStepRepository;
    }

    @Transactional
    public Recipe criarReceita(RecipeCreateDTO dto) {

        if(dto.getUserId() == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "UserId é obrigatório");
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Usuário não encontrado"));

        // Cria receita sem ingredientes para gerar o UUID
        Recipe recipe = new Recipe();
        recipe.setTitulo(dto.getTitulo());
        recipe.setDescricao(dto.getDescricao());
        recipe.setCategoria(dto.getCategoria());
        recipe.setTempoDePreparo(dto.getTempoDePreparo());
        recipe.setImagemUrl(dto.getImagemUrl());
        recipe.setUser(user);

        recipe = recipeRepository.save(recipe); // salva e gera UUID

        if (dto.getIngredientes() != null) {
            for (IngredientQuantityDTO iq : dto.getIngredientes()) {

                if (iq.getIngredienteNome() == null || iq.getIngredienteNome().isBlank()) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Ingrediente inválido: nome obrigatório");
                }

                Ingredient ingredient = ingredientRepository.findByNameIgnoreCase(iq.getIngredienteNome())
                        .orElseGet(() -> {
                            Ingredient novo = new Ingredient();
                            novo.setName(iq.getIngredienteNome());
                            return ingredientRepository.save(novo);
                        });

                RecipeIngredient ri = new RecipeIngredient();
                ri.setRecipe(recipe);
                ri.setIngredient(ingredient);
                ri.setQuantidade(iq.getQuantidade());

                // agora o recipeId já existe
                ri.setId(new RecipeIngredientId(recipe.getId(), ingredient.getId()));

                recipe.getIngredientes().add(ri);
            }
            recipe = recipeRepository.save(recipe); // salva os ingredientes
        }

        if(dto.getPassos() != null){
            for(RecipeStepDTO passoDTO : dto.getPassos()){
                RecipeStep passo = new RecipeStep();
                passo.setRecipe(recipe);
                passo.setOrdem(passoDTO.getOrdem());
                passo.setDescricao(passoDTO.getDescricao());

                recipe.getPassos().add(passo);
            }
            recipeStepRepository.saveAll(recipe.getPassos());
        }

        return recipe;
    }

    public List<Recipe> listarTodas () {
        return recipeRepository.findAll();
    }

    public Recipe buscarPorId(UUID id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Receita não encontrada"));
    }

    public void deletarPorId (UUID id){
        if (!recipeRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Receita não encontrada");
        }
        recipeRepository.deleteById(id);
    }

    @Transactional
    public Recipe atualizar(UUID id, Recipe recipeAtualizada) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receita não encontrada"));

        if (recipeAtualizada.getTitulo() != null) recipe.
                setTitulo(recipeAtualizada.getTitulo());
        if (recipeAtualizada.getDescricao() != null) recipe.
                setDescricao(recipeAtualizada.getDescricao());
        if (recipeAtualizada.getCategoria() != null) recipe.
                setCategoria(recipeAtualizada.getCategoria());
        if (recipeAtualizada.getTempoDePreparo() != null) recipe.
                setTempoDePreparo(recipeAtualizada.getTempoDePreparo());
        if (recipeAtualizada.getImagemUrl() != null) recipe.
                setImagemUrl(recipeAtualizada.getImagemUrl());
        if (recipeAtualizada.getPassos() != null) recipe.
                setPassos(recipeAtualizada.getPassos());

        return recipeRepository.save(recipe);
    }
}
