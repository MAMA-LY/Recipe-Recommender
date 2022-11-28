package com.brainfood.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;



public class UserInfoProvider implements UserDetailsService{


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx  ");
        return new UserInfo();
    }
    
}
