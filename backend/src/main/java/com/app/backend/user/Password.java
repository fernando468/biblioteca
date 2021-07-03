package com.app.backend.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Password {
    @Column(name = "password", nullable = false)
    private String description;

    public Password(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.description = passwordEncoder.encode(password);
    }

    public static boolean comparePassword(String passwordDTO, String passwordSaved) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(passwordDTO, passwordSaved);
    }

}
