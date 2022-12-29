package com.brainfood.security.repository;

import com.brainfood.security.model.PasswordResetToken;
import com.brainfood.security.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String> {
    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(UserCredentials user);
}
