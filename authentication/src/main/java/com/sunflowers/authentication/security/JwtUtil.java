package com.sunflowers.authentication.security;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "nFlBpBAf5sAgyEwZpvToGPVPtvFK0CkeEaZj+lLAhx8Baewz7DAYGC8X4j+RIf7l12moU5mdlnLK3CRavuTOtaQ5ddb0gYjmLkMGEHIjT5X1cUZ5CVKec1s+cNT+wphpdgBHrJo42z2LuQF6tLQMyyC6su05MeYXVuicVyzAS4PLYy2Orqn+ltcPsKlCmEeNZD9xAGQDuNTGMoZEZY3r//KlS/fDOnwAtNPAAASAfbfFhN66pHPlme1mxmxhZPV38FUi5G9QbD8Jk3mN64iyiDUNxJQTXQ4qJb5wJz6GMeMZAhYMamPLEBSbsl3rFWZbzf2jpkBeCAdFdiTDCXBlNtmGflTqOPZTTcCIitWn/0E";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }
}
