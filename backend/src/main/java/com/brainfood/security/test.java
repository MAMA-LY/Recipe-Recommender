package com.brainfood.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@Order(1)
public class test implements ApplicationRunner {
    @Autowired
    UserAuthenticator userAuthenticator;

    @Override
    public void run(ApplicationArguments arguments) throws ParseException {
        System.out.println(userAuthenticator.createAuthentications("nali", "iovleouy", "lioevouy@gmail.com",
                "180", "70", "female", "2001-11-14").name());
    }
    }

