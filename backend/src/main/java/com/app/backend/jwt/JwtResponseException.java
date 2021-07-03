package com.app.backend.jwt;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.backend.shared.exceptions.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;

public class JwtResponseException {

    public HttpServletResponse response(HttpServletResponse response, Exception ex, HttpServletRequest request,
            String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), message,  ex.getMessage(), request.getRequestURI());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setHeader("Content-Type", "application/json");
        try {
            response.getOutputStream().print(objectMapper.writeValueAsString(error));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
