package com.brainfood.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.brainfood.security.Model.UserCredentials;

import  org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.web.csrf.CsrfFilter;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;


    // SHOULD BE MODIFIED EVERYTIME A NEW URI ADDED TO ANY REST CONTROLLER TO CONTROL AUTHORIZATION
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http.anonymous().disable().authorizeHttpRequests().requestMatchers("/signin/**").permitAll().and()
            .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/forgetPassword/**").permitAll().and()
            .authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/resetPassword/**").permitAll().and()
            .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/changePassword/**").permitAll().and()
            .authorizeHttpRequests().requestMatchers("/home/**").authenticated().and()
            .authorizeHttpRequests().requestMatchers("/").authenticated().and()
            .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/signup/**").permitAll().and()
            .formLogin().loginPage("/signin").defaultSuccessUrl("/home").loginProcessingUrl("/signin").and()
            .logout().logoutUrl("/signout").logoutRequestMatcher(new AntPathRequestMatcher("/signout")).logoutSuccessUrl("/signin")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .addLogoutHandler(new SecurityContextLogoutHandler()).and()
            .csrf().disable();;

            return http.build();
    }

    
}
