package com.brainfood.security.Repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brainfood.security.Model.UserCredentials;


public interface UserRepository extends JpaRepository<UserCredentials, String> {
    UserCredentials findByUsername(String username);
    UserCredentials findByEmail(String email);
}