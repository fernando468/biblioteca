package com.app.backend.shared.exceptions;

public class ResourceNotFound extends RuntimeException {
    
    public ResourceNotFound(String message) {
        super(message);
    }
}
