package com.fnb.orderservice.security.impl;

import com.fnb.orderservice.security.JwtService;

import java.util.Date;

public class JwtServiceImpl implements JwtService {
    @Override
    public boolean validateToken(String token) {
        try{
            Claims claims = parseClaims(token);
            //boolean usernameMatched = claims.getSubject().equals(email);
            boolean notExpired = claims.getExpiration().before(new Date());
            return notExpired;
        } catch (ExpiredJwtException e){
            return false;
        }
    }

    @Override
    public String extractUsername(String token) {
        return "";
    }

    @Override
    public String extractRole(String token) {
        return "";
    }

    @Override
    public String extractEmailFromToken(String token) {
        return "";
    }
}
