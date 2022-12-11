package com.brainfood.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.brainfood.security.Model.UserCredentials;
import com.brainfood.security.Repository.UserRepository;

import lombok.Getter;
import lombok.Setter;


@Component
public class UserAuthenticator {
    
    @Autowired
    UserRepository userRepository;

    @Getter
    @Setter
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;


    public Response createAuthentications(String username, String password, String email) {
        if(userExistsByUsername(username)) return Response.UsernameAlreadyExists;
        if(userExistsByEmail(email)) return Response.EmailAlreadyExists;
        String encryptedPD = this.bCryptPasswordEncoder.encode(password);
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setPassword(encryptedPD);
        userCredentials.setUsername(username);
        userCredentials.setEmail(email);
        userRepository.save(userCredentials);
        System.out.println(encryptedPD.length());
        return Response.UserCreated;
    }

   
    public UserCredentials getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public UserCredentials getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public boolean userExistsByEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public boolean userExistsByUsername(String username) {
        return userRepository.findByUsername(username) != null;
    }
    


    
}
