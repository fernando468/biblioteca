package com.app.backend.customer.exceptions;

public class UserIsAlreadyRegistered extends RuntimeException {
    public UserIsAlreadyRegistered(String message) {
        super(message);
    }
}
