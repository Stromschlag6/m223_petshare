package com.petshare.petshare_api.service;

import com.petshare.petshare_api.entity.ApplicationUser;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY = "meinGeheimesToken"; // in .env/.properties speichern in echten Projekten
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 Stunde

    public String generateToken(ApplicationUser user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean isTokenValid(String token, ApplicationUser user) {
        return extractUsername(token).equals(user.getUsername());
    }
}
