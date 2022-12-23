package com.brainfood.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainfood.security.Model.PasswordResetToken;
import com.brainfood.security.Model.UserCredentials;

@Repository
<<<<<<< HEAD
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String>{
    PasswordResetToken findByToken(String token);
=======
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String> {
    PasswordResetToken findByToken(String token);

>>>>>>> main
    PasswordResetToken findByUser(UserCredentials user);
}
