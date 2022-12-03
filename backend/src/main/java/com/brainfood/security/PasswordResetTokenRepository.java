package com.brainfood.security;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainfood.backend.UserCredentials;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String>{
    public PasswordResetToken findByToken(String token);
    public PasswordResetToken findByUser(UserCredentials user);
}
