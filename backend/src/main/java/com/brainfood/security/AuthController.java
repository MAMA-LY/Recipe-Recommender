package com.brainfood.security;

import com.brainfood.security.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Map;

@Component
@RestController
public class AuthController {

    @Autowired
    UserAuthenticator userAuthenticator;

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Autowired
    PasswordResetManager passwordResetManager;

    @PostMapping("/forgetPassword")
    public String forgetPassword(@RequestParam Map<String, String> body) {
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
    public String createAuthentications(@RequestParam Map<String, String> auths) throws ParseException {
        return userAuthenticator.createAuthentications(auths.get("username"), auths.get("password"), auths.get("email"),
                auths.get("height"), auths.get("weight"), auths.get("gender"), auths.get("birthdate")).name();
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
