package com.brainfood.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainfood.backend.db_entities.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, String> {
    UserCredentials findByUsername(String username);

    UserCredentials findByEmail(String email);
}
