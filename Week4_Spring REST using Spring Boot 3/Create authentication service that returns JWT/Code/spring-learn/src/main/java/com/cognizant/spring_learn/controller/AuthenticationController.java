package com.cognizant.spring_learn.controller;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @GetMapping
    public String generateJwt(Authentication authentication) {
        String username = authentication.getName();
        String secret = "ThisIsASecretKeyForJWTs1234567890!"; // At least 32 chars
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 mins
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return "{\"token\": \"" + token + "\"}";
    }
}
