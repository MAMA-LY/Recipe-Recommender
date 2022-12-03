package com.brainfood.security;
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
import com.brainfood.backend.UserCredentials;
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

    // @GetMapping("/login")
    // public boolean authenticate(HttpServletRequest httpServletRequest) {
    //     String authHeader = httpServletRequest.getHeader("Authorization").substring(6);
    //     String decodedAuth = new String(Base64.decodeBase64(authHeader));
    //     String username = decodedAuth.substring(0, decodedAuth.indexOf(":"));
    //     String password = decodedAuth.substring(decodedAuth.indexOf(":"), decodedAuth.length());
    //     return userAuthenticator.authenticate(username, password);
    // }


    @PostMapping("/forgetPassword")
    public void forgestPassword(@RequestParam Map<String, String> body){
        passwordResetManager.sendResetPassword(body.get("email"));
    }

    @GetMapping("/resetPassword")
    public boolean resetPassword(@RequestParam(name = "tk") String token) {
        return passwordResetManager.verifyToken(token);
    }

    @PostMapping("/changePassword")
    public boolean changePassword(@RequestParam Map<String, String> body) {
        return passwordResetManager.changePassword(body.get("tk"), body.get("password"));
    }

    @PostMapping("/signup")
    public boolean createAuthentications(@RequestParam Map<String, String> auths) {
        return userAuthenticator.createAuthentications(auths.get("username"), auths.get("password"), auths.get("email"));
    }

    @GetMapping("/home")
    public String test() {
        UserInfo userInfo2 = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userInfo2.getUsername());
        System.out.println(userRepository.findByUsername(userInfo2.getUsername()).getEmail());
        return "Home";
    }

    @GetMapping("/signin")
    public String test3() {
        return "Signin";
    }


    @GetMapping("/signinFailed")
    public String test4() {
        return "SignInFalied";
    }

   

}
