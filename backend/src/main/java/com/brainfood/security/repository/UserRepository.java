package com.brainfood.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainfood.security.model.UserCredentials;

public interface UserRepository extends JpaRepository<UserCredentials, String> {
    UserCredentials findByUsername(String username);

    UserCredentials findByEmail(String email);
}
