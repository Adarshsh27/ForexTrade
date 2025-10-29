package com.forextrade.microservice.config.jwt;


import com.forextrade.microservice.config.security.UserPrincipal;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {
    @Value("${auth.token.jwtSecret}")
    private String jwtSecret;
    @Value("${auth.token.expirationInMillis}")
    private int expirationTime;

    public String generateTokenForUser(Authentication authentication){
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        List<String> roles = userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return Jwts.builder()
                .subject(userPrincipal.getUsername())
                .claim("id" , userPrincipal.getUser().getUserId())
                .claim("roles" , roles)
                .claim("email" , userPrincipal.getUser().getEmailId())
                .claim("fullName" , userPrincipal.getUser().getFullName())
                .claim("country" , userPrincipal.getUser().getCountry())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + expirationTime))
                .signWith(key() , SignatureAlgorithm.HS256)
                .compact();
    }
    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            throw new JwtException(e.getMessage());
        }
    }
}
