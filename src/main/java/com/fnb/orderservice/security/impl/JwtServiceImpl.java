package com.fnb.orderservice.security.impl;

import com.fnb.orderservice.security.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private SecretKey signingKey(){
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public boolean validateToken(String token) {
        try{
            Claims claims = parseClaims(token);
            //boolean usernameMatched = claims.getSubject().equals(email);
            return claims.getExpiration().before(new Date());
        } catch (ExpiredJwtException e){
            return false;
        }
    }

    @Override
    public String extractRole(String token) {
        return parseClaims(token).get("ROLE", String.class);
    }

    @Override
    public String extractEmailFromToken(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token){
        return Jwts.parser()
                .verifyWith(signingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
