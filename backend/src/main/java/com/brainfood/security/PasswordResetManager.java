package com.brainfood.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.brainfood.backend.UserCredentials;


@Service
public class PasswordResetManager {

    @Autowired
    UserAuthenticator userAuthenticator;


    @Autowired
    EmailSender emailSender;


    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    public void sendResetPassword(String email) {
        UserCredentials user = userAuthenticator.getUserByEmail(email);
        if(user == null) return;
        PasswordResetToken token = new PasswordResetToken();
        token.setUser(user);
        passwordResetTokenRepository.save(token);
        String emailBody = "Click here to Reset your Password : http://localhost:8080/resetPassword?tk=" + token.getToken();
        emailSender.sendEmail(user.getEmail(), "Brainfood Reset Password", emailBody);
    }

    public boolean verifyToken(String tokenStr) {
        PasswordResetToken token = passwordResetTokenRepository.findByToken(tokenStr);
        if(token == null) return false;
        return true;
    }

    public boolean changePassword(String tokenStr, String password) {
        UserCredentials user = passwordResetTokenRepository.findById(tokenStr).get().getUser();
        user.setPassword(userAuthenticator.bCryptPasswordEncoder.encode(password));
        passwordResetTokenRepository.deleteById(tokenStr);
        userAuthenticator.expireUserByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return true; 
    }

}
