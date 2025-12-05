package com.joaohenrique.ailinter.dto;

import com.joaohenrique.ailinter.model.user.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
}
