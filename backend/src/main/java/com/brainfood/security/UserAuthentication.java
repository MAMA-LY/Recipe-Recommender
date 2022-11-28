package com.brainfood.security;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


public class UserAuthentication implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
    
}
