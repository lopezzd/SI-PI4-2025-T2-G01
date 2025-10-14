package com.joaohenrique.ai_linter.services;

import com.joaohenrique.ai_linter.domain.user.User;
import com.joaohenrique.ai_linter.dto.UserResponseDTO;
import com.joaohenrique.ai_linter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(UUID id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
