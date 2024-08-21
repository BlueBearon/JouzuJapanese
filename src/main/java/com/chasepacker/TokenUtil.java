package com.chasepacker;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

import java.util.Date;

public class TokenUtil {

    private static final Key SECRET_KEY = Keys.hmacShaKeyFor("CrLs2bH0sItusUD8Cbk5DMC4DulqyVZJvU9NY+VhbGY=".getBytes());

    public static String generateToken(String username) {

        System.out.println("    TokenUtil.java: Generating token for user: " + username);

        try {
            String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();


            return token;
        } catch (Exception e) {
            System.out.println("    TokenUtil.java: Error generating token: " + e.getMessage());
            return null;  
        }
        
    }

    public static TokenValidationResponse validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
            String username = claims.getSubject();
            return new TokenValidationResponse(true, username);
        } catch (Exception e) {
            return new TokenValidationResponse(false, null);
        }
    }

    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}


/**
 * This class is a simple POJO used to represent the request body for the login endpoint.
 */
class TokenValidationResponse {

    private boolean valid;
    private String username;

    public TokenValidationResponse(boolean valid, String username) {
        this.valid = valid;
        this.username = username;
    }

    public boolean isValid() {
        return valid;
    }

    public String getUsername() {
        return username;
    }

}
