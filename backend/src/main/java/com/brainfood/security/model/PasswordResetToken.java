package com.brainfood.security.model;

import java.io.Serializable;
import java.util.UUID;

import com.brainfood.backend.db_entities.UserCredentials;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
