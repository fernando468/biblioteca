package com.app.backend.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import com.app.backend.user.User;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    public static final long HOURS_IN_SECONDS = 43200;

    private final String secret = "secret";

    // retorna o username do token jwt
    public String getUsernameFromToken(String token) {
        Claims claims = this.getAllClaimsFromToken(token);
        try {
            return claims.get("email").toString();
        } catch (SignatureException | UnsupportedJwtException | IllegalArgumentException ex) {
            throw new BadCredentialsException(ex.getMessage(), ex);
        } catch (MalformedJwtException ex) {
            throw new MalformedJwtException(ex.getMessage(), ex);
        } catch (ExpiredJwtException ex) {
            throw new ExpiredJwtException(Jwts.header(), claims, token);
        }
    }

    // retorna expiration date do token jwt
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);

    }

    // para retornar qualquer informação do token nos iremos precisar da secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    // check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // gera token para user
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(
                claims,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().getName().toString()
        );
    }

    // Cria o token e define tempo de expiração pra ele
    private String doGenerateToken(Map<String, Object> claims, UUID id, String nome, String email, String userType) {
        claims.put("name", nome);
        claims.put("email", email);
        claims.put("role", userType);
        return Jwts.builder().setClaims(claims).setSubject(id.toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + HOURS_IN_SECONDS * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    // valida o token
    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}