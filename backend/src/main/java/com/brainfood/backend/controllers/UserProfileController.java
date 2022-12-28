package com.brainfood.backend.controllers;

import com.brainfood.backend.models.UserProfile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account_settings")
public class UserProfileController {

    @GetMapping("/userProfile")
    public UserProfile getUserProfile(){
        UserProfile userProfile=new UserProfile();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();


        userProfile.builder().username(username).build();
        return userProfile;
    }
}
