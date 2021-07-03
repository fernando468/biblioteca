package com.app.backend.authentication;

import java.util.ArrayList;
import java.util.List;

import com.app.backend.authentication.dto.LoginDTO;
import com.app.backend.authentication.exceptions.InvalidLogin;
import com.app.backend.jwt.JwtTokenUtil;
import com.app.backend.jwt.TokenResponse;
import com.app.backend.shared.exceptions.ResourceNotFound;
import com.app.backend.user.EnumRole;
import com.app.backend.user.Password;
import com.app.backend.user.User;
import com.app.backend.user.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    private final UserRepository repository;
    private final JwtTokenUtil jwtTokenUtil;

    AuthenticationService(UserRepository customerRepository, JwtTokenUtil jwtTokenUtil) {
        this.repository = customerRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public ResponseEntity<TokenResponse> signIn(LoginDTO loginDTO) {
        User user = this.repository.findByEmail(loginDTO.getEmail());
        TokenResponse token = validateUser(loginDTO, user);
        if (!token.getToken().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(token);
        }
        throw new ResourceNotFound("User with email: " + loginDTO.getEmail() + " not found");
    }

    public ResponseEntity<TokenResponse> signInAdmin(LoginDTO loginDTO) {
        User user = this.repository.findByEmailAndRoleName(loginDTO.getEmail(), EnumRole.ROLE_ADMIN);
        TokenResponse token = validateUser(loginDTO, user);
        if (!token.getToken().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(token);
        }
        throw new ResourceNotFound("Admin with email: " + loginDTO.getEmail() + " not found!");
    }

    private TokenResponse validateUser(LoginDTO loginDTO, User user) {
        String token = "";
        if (user != null) {
            boolean passwordIsCorrect = Password.comparePassword(
                    loginDTO.getPassword(),
                    user.getPassword().getDescription()
            );
            if (passwordIsCorrect) {
                token = jwtTokenUtil.generateToken(user);
            } else {
                throw new InvalidLogin("Email or password is incorrect!");
            }
        }
        return new TokenResponse(token);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = this.repository.findByEmail(email);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName().toString()));
        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword().getDescription(),
                authorities
        );
    }

}
