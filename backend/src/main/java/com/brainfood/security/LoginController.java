package com.brainfood.security;
import java.util.Enumeration;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@ComponentScan
@RestController
public class LoginController {

    @GetMapping("/login")
    public String testResponse(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getMethod());
        System.out.println(httpServletRequest.getCharacterEncoding());
        System.out.println(httpServletRequest.getHeader("Authorization"));

        return "asdassdaxx";
    }
}
