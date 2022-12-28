package com.brainfood.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brainfood.security.model.UserCredentials;
import com.brainfood.security.repository.UserRepository;

@Service
public class UserInfoProvider implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = userRepository.findByUsername(username);
        if (userCredentials == null)
            throw new UsernameNotFoundException("Username Not Found : " + username);
        return new UserInfo(userCredentials);
    }

}
