package com.app.backend.authentication;

import com.app.backend.authentication.dto.LoginDTO;
import com.app.backend.jwt.TokenResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService service;
    
    AuthenticationController(AuthenticationService authenticationService) {
        this.service = authenticationService;
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signIn(@RequestBody LoginDTO loginDTO) {
        return this.service.signIn(loginDTO);
    }

    @PostMapping("/admin/signin")
    public ResponseEntity<TokenResponse> signInAdmin(@RequestBody LoginDTO loginDTO) {
        return this.service.signInAdmin(loginDTO);
    }
}
