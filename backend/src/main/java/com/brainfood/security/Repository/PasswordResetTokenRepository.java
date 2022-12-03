package com.brainfood.security.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainfood.security.Model.PasswordResetToken;
import com.brainfood.security.Model.UserCredentials;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String>{
    public PasswordResetToken findByToken(String token);
    public PasswordResetToken findByUser(UserCredentials user);
}
