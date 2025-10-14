package com.joaohenrique.ai_linter.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

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

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, max = 32)
    private String password;
}
