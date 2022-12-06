package com.brainfood.security;

import java.sql.ResultSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import com.brainfood.security.Repository.PasswordResetTokenRepository;

@Configuration
@EnableScheduling
class Scheduler {

    @Autowired
    SessionRegistry sessionRegistry;

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;
    

    @Scheduled(timeUnit = TimeUnit.DAYS, fixedRate = 1)
    public void clearPasswordResetTokensRepo() {
        passwordResetTokenRepository.deleteAll();
    }


}