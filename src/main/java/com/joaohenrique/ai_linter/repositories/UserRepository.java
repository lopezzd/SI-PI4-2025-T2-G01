package com.joaohenrique.ai_linter.repositories;


import com.joaohenrique.ai_linter.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserById(UUID id);
}
