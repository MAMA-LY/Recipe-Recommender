package com.brainfood.security.Model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;


@Component
@ToString
@Entity
@Table(name = "\"UserCredentials\"")
@Getter @Setter
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
