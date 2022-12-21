package com.brainfood.security.repository;

import com.brainfood.security.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserCredentials, String> {
    UserCredentials findByUsername(String username);

    UserCredentials findByEmail(String email);
}
