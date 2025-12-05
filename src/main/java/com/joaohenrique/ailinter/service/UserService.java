package com.joaohenrique.ailinter.service;

import com.joaohenrique.ailinter.model.user.User;
import com.joaohenrique.ailinter.dto.UserRequestDTO;
import com.joaohenrique.ailinter.dto.UserResponseDTO;
import com.joaohenrique.ailinter.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public UserResponseDTO updateUser(UUID id, UserRequestDTO userData) {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

        user.setName(userData.name());
        user.setEmail(userData.email());
        user.setPassword(userData.password());

        user = repository.save(user);
        return new UserResponseDTO(user);
    }
}