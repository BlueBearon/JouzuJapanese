package com.chasepacker;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {

    private static final String SECRET_KEY = "CrLs2bH0sItusUD8Cbk5DMC4DulqyVZJvU9NY+VhbGY=";
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static TokenValidationResponse validateToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            String username = claims.getSubject();
            return new TokenValidationResponse(true, username);
        } catch (Exception e) {
            return new TokenValidationResponse(false, null);
        }
    }

    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
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
