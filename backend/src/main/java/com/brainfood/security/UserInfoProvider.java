package com.brainfood.security;

import com.brainfood.backend.db_repositories.UserRepository;
import com.brainfood.security.model.UserCredentials;
import com.brainfood.security.repository.UserCredentialsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoProvider implements UserDetailsService {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = userCredentialsRepository.findByUsername(username);
        if (userCredentials == null)
            throw new UsernameNotFoundException("Username Not Found : " + username);
        return new UserInfo(userCredentials);
    }

}
