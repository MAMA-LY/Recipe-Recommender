package com.brainfood.security;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.brainfood.backend.UserCredentials;



public interface UserRepository extends JpaRepository<UserCredentials, String> {
    UserCredentials findByUsername(String username);
    UserCredentials findByEmail(String email);
}
