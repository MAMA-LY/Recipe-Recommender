package com.brainfood.security;
import java.util.Enumeration;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletRequest;

@ComponentScan
@RestController
public class LoginController {


    @GetMapping("/login")
    public String testResponse(@RequestParam(name="name") String name, @RequestParam(name="pd") String pd) {
        return "Saved";
    }
}
