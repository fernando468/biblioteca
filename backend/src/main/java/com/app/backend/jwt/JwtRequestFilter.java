package com.app.backend.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.backend.authentication.AuthenticationService;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final AuthenticationService authService;
    private final JwtTokenUtil jwtTokenUtil;

    public JwtRequestFilter(AuthenticationService authService, JwtTokenUtil jwtTokenUtil) {
        this.authService = authService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // ObjectMapper objectMapper = new ObjectMapper();
        JwtResponseException jwtResponseException = new JwtResponseException();
        try {
            final String requestTokenHeader = request.getHeader("Authorization");
            String email = null;
            String jwtToken = null;
            
            // JWT Token está no form "Bearer token". Remova a palavra Bearer e pegue
            // somente o Token
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                jwtToken = requestTokenHeader.substring(7);
                email = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }
            // Tendo o token, valide o.
            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.authService.loadUserByUsername(email);
                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            chain.doFilter(request, response);
        } catch (BadCredentialsException ex) {
            jwtResponseException.response(response, ex, request, "BAD_CREDENTIALS");
        } catch (SignatureException | UnsupportedJwtException | IllegalArgumentException ex) {
            jwtResponseException.response(response, ex, request, "INVALID_TOKEN");
        } catch (MalformedJwtException ex) {
            jwtResponseException.response(response, ex, request, "MALFORMED_TOKEN");
        } catch (ExpiredJwtException ex) {
            jwtResponseException.response(response, ex, request, "EXPIRED_TOKEN");
        }
    }
}
