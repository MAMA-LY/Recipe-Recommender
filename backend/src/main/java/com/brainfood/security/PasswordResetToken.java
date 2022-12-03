package com.brainfood.security;

import java.io.Serializable;
import java.util.UUID;

import com.brainfood.backend.UserCredentials;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "\"PasswordResetToken\"")
@Data
public class PasswordResetToken implements Serializable {

    @Id
    @Column(name = "Token")
    private String token;

    public PasswordResetToken() {
        this.token = UUID.randomUUID().toString();
    }

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    private UserCredentials user;
}
