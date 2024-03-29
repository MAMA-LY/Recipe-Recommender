package com.brainfood.backend.controllers;

import com.brainfood.backend.DAO;
import com.brainfood.backend.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@RestController
@RequestMapping("account_settings")
public class UserProfileController {

    @Autowired
    DAO DAO;
    @GetMapping("/userProfile")
    public UserProfile getUserProfile(){
        return DAO.getUserProfile();
    }
}
