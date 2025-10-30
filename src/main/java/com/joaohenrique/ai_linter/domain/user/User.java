package com.joaohenrique.ai_linter.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID UUID;

    @NotBlank(message = "O nome não pode estar em branco!")
    @Size(min = 1, max = 50)
    private String firstName;

    @NotBlank(message = "O sobrenome não pode estar em branco!")
    @Size(min = 1, max = 50)
    private String lastName;

    @Column(unique = true, length = 11)
    @NotNull
    @Pattern(regexp = "^(?:\\d{9}|\\d{11})$", message = "Documento deve ter 9 ou 11 dígitos numéricos.")
    private String document;

    @Column(unique = true)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, max = 32)
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
