package com.cauapaula.receitas.service;

import com.cauapaula.receitas.dto.UserCreateDTO;
import com.cauapaula.receitas.model.User;
import com.cauapaula.receitas.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User criarUsuario(UserCreateDTO dto) {
        if (userRepository.findAll().stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(
                        dto.getEmail()))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado");
        }

        User user = new User();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return userRepository.save(user);
    }
}
