package com.joaohenrique.ai_linter.dto;

import com.joaohenrique.ai_linter.domain.user.User;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String firstName,
        String lastName,
        String document,
        String email
) {
    public UserResponseDTO(User user) {
        this(
                user.getUUID(),
                user.getFirstName(),
                user.getLastName(),
                user.getDocument(),
                user.getEmail()
        );
    }
}