package com.joaohenrique.ailinter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "O nome não pode estar em branco!")
        @Size(min = 1, max = 50)
        String name,

        @NotBlank(message = "O email não pode estar em branco!")
        @Email(message = "Email inválido!")
        String email,

        @NotBlank(message = "A senha não pode estar em branco!")
        @Size(min = 6, max = 32)
        String password
) {
}