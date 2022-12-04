package com.brainfood.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
public class AppConfig {
    @Bean
    public BCryptPasswordEncoder transferService() {
        return new BCryptPasswordEncoder();
    }
   
    @Bean
    SessionRegistry sessionRegistry() { 
        return new SessionRegistryImpl(); 
    }
}
