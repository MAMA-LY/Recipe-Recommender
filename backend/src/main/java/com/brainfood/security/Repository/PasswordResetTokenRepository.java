package com.brainfood.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainfood.security.Model.PasswordResetToken;
import com.brainfood.security.Model.UserCredentials;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String> {
    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(UserCredentials user);
}
