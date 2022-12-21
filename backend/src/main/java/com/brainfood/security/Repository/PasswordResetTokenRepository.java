package com.brainfood.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainfood.security.model.PasswordResetToken;
import com.brainfood.security.model.UserCredentials;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String>{
    PasswordResetToken findByToken(String token);
    PasswordResetToken findByUser(UserCredentials user);
}
