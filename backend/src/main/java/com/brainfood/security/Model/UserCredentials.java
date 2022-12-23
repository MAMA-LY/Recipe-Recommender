package com.brainfood.security.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ToString
@Entity
@Table(name = "\"UserCredentials\"")
@Getter
@Setter
public class UserCredentials implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

}
