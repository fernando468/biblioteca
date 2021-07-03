package com.app.backend.authentication.exceptions;

public class InvalidLogin extends RuntimeException {
    public InvalidLogin(String message) {
        super(message);
    }
}