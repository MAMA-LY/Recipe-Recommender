package com.brainfood.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.brainfood.security.Model.PasswordResetToken;
import com.brainfood.security.Model.UserCredentials;
import com.brainfood.security.Repository.PasswordResetTokenRepository;


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

    public String verifyToken(String tokenStr) {
        PasswordResetToken token = passwordResetTokenRepository.findByToken(tokenStr);
        if(token == null) return "Invalid Token";
        return "Token Verified";
    }

    public String changePassword(String tokenStr, String password) {
        PasswordResetToken token = passwordResetTokenRepository.findByToken(tokenStr);
        if(token == null) return "Invalid Token";
        UserCredentials user = passwordResetTokenRepository.findById(tokenStr).get().getUser();
        user.setPassword(userAuthenticator.bCryptPasswordEncoder.encode(password));
        passwordResetTokenRepository.deleteById(tokenStr);
        return "Password Changed"; 
    }

}
