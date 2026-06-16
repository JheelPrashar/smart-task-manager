package com.example.stm.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(String username) {

        String token= Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .claim("role","ADMIN")
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();

                return token;
    }

    public boolean isValid(String token){
        try{
            Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
            .build()
            .parseSignedClaims(token);

            return true;
        }catch(Exception e){
            return false;
        }
    }
    public String getUserName(String token){
        return Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();


    }
}