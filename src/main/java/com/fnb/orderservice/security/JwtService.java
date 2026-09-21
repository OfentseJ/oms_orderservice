package com.fnb.orderservice.security;

public interface JwtService {

    boolean validateToken(String token);

    String extractRole(String token);

    String extractEmailFromToken(String token);

}
