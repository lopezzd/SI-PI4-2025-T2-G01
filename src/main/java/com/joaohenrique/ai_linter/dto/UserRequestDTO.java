package com.joaohenrique.ai_linter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "O nome não pode estar em branco!")
        @Size(min = 1, max = 50)
        String firstName,

        @NotBlank(message = "O sobrenome não pode estar em branco!")
        @Size(min = 1, max = 50)
        String lastName,

        @NotBlank(message = "O documento não pode estar em branco!")
        @Pattern(regexp = "^(?:\\d{9}|\\d{11})$", message = "Documento deve ter 9 ou 11 dígitos numéricos.")
        String document,

        @NotBlank(message = "O email não pode estar em branco!")
        @Email(message = "Email inválido!")
        String email,

        @NotBlank(message = "A senha não pode estar em branco!")
        @Size(min = 6, max = 32)
        String password
) {
}