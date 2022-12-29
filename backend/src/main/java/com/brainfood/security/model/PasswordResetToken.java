package com.brainfood.security.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "\"PasswordResetToken\"")
@Getter
@Setter
public class PasswordResetToken implements Serializable {

    @Id
    @Column(name = "Token")
    private String token;

    public PasswordResetToken() {
        this.token = UUID.randomUUID().toString();
    }

    @OneToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    private UserCredentials user;
}
