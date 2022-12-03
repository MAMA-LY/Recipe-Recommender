package com.brainfood.security;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brainfood.security.Model.UserCredentials;
import com.brainfood.security.Repository.UserRepository;
import com.brainfood.security.Repository.UserRepository;


import jakarta.servlet.http.HttpServletRequest;



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
    public void forgestPassword(@RequestParam Map<String, String> body){
        passwordResetManager.sendResetPassword(body.get("email"));
    }

    @GetMapping("/resetPassword")
    public String resetPassword(@RequestParam(name = "tk") String token) {
        return passwordResetManager.verifyToken(token);
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam Map<String, String> body) {
        return passwordResetManager.changePassword(body.get("tk"), body.get("password"));
    }

    @PostMapping("/signup")
    public String createAuthentications(@RequestParam Map<String, String> auths) {
        return userAuthenticator.createAuthentications(auths.get("username"), auths.get("password"), auths.get("email"));
    }

    @GetMapping("/home")
    public String test() {
        return "UserInfo";
    }

    @GetMapping("/signin")
    public String signin() {
        return "Sign In";
    }


    


}
