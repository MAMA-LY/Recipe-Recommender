package com.brainfood.security;

import org.springframework.beans.factory.annotation.Autowired;

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

    public Response sendResetPassword(String email) {
        UserCredentials user = userAuthenticator.getUserByEmail(email);
        if(user == null) return Response.NoUserFoundByThisEmail;
        PasswordResetToken oldToken = passwordResetTokenRepository.findByUser(user);
        if(oldToken != null) {
            passwordResetTokenRepository.delete(oldToken);
        }
        PasswordResetToken token = new PasswordResetToken();
        while(passwordResetTokenRepository.findByToken(token.getToken()) != null) {
            token = new PasswordResetToken();
        }
        token.setUser(user);
        passwordResetTokenRepository.save(token);
        // NEEDS TO BE CHANGED LATER
        String emailBody = "Click here to Reset your Password : http://localhost:8080/resetPassword?tk=" + token.getToken();
        emailSender.sendEmail(user.getEmail(), "Brainfood Reset Password", emailBody);
        return Response.PasswordResetEmailSent;
    }

    public Response verifyToken(String tokenStr) {
        PasswordResetToken token = passwordResetTokenRepository.findByToken(tokenStr);
        if(token == null) return Response.InvalidToken;
        return Response.TokenVerified;
    }

    public Response changePassword(String tokenStr, String password) {
        PasswordResetToken token = passwordResetTokenRepository.findByToken(tokenStr);
        if(token == null) return Response.InvalidToken;
        UserCredentials user = passwordResetTokenRepository.findById(tokenStr).get().getUser();
        user.setPassword(userAuthenticator.bCryptPasswordEncoder.encode(password));
        passwordResetTokenRepository.deleteById(tokenStr);
        return Response.PasswordChanged; 
    }

}
