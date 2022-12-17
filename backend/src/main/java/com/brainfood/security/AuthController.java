package com.brainfood.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brainfood.security.Repository.UserRepository;

@Component
@RestController
public class AuthController {

    @Autowired
    UserAuthenticator userAuthenticator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordResetManager passwordResetManager;


    @PostMapping("/forgetPassword")
    public String forgestPassword(@RequestParam Map<String, String> body){
        return passwordResetManager.sendResetPassword(body.get("email")).name();
    }

    @GetMapping("/resetPassword")
    public String resetPassword(@RequestParam(name = "tk") String token) {
        return passwordResetManager.verifyToken(token).name();
    }

    
    @PostMapping("/changePassword")
    public String changePassword(@RequestParam Map<String, String> body) {
        return passwordResetManager.changePassword(body.get("tk"), body.get("password")).name();
    }


    @PostMapping("/signup")
    public String createAuthentications(@RequestParam Map<String, String> auths) {
        return userAuthenticator.createAuthentications(auths.get("username"), auths.get("password"), auths.get("email")).name();
    }

    @GetMapping("/home")
    public String test() {
        return "UserInfo";
    }


    @GetMapping("/signin")
    public String signin() {
        return Response.PleaseSignIn.name();
    }
    


}
