package com.joaohenrique.ailinter.dto;

import com.joaohenrique.ailinter.model.user.User;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email
) {
    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}