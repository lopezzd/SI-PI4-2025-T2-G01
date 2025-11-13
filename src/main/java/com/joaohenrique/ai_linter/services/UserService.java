package com.joaohenrique.ai_linter.services;

import com.joaohenrique.ai_linter.domain.user.User;
import com.joaohenrique.ai_linter.dto.UserRequestDTO;
import com.joaohenrique.ai_linter.dto.UserResponseDTO;
import com.joaohenrique.ai_linter.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsers() {
        return repository.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserResponseDTO getUserById(UUID id) {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        return new UserResponseDTO(user);
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userData) {
        User newUser = new User();
        newUser.setFirstName(userData.firstName());
        newUser.setLastName(userData.lastName());
        newUser.setDocument(userData.document());
        newUser.setEmail(userData.email());
        newUser.setPassword(userData.password());

        newUser = repository.save(newUser);
        return new UserResponseDTO(newUser);
    }

    @Transactional
    public UserResponseDTO updateUser(UUID id, UserRequestDTO userData) {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

        user.setFirstName(userData.firstName());
        user.setLastName(userData.lastName());
        user.setDocument(userData.document());
        user.setEmail(userData.email());
        user.setPassword(userData.password());

        user = repository.save(user);
        return new UserResponseDTO(user);
    }

    @Transactional
    public void deleteUser(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado!");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Falha de integridade referencial");
        }
    }
}