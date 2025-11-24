package com.authorization.basicauth.util;

import com.authorization.basicauth.entity.ApplicationUsers;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {

    @Value("${secretKey}")
    public String jwtSecretKey;

    public SecretKey getSecretKey() {
        System.out.println(jwtSecretKey);
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(ApplicationUsers user){
        return Jwts.builder().subject(user.getUserName())
                .claim("userId", user.getUserId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ 10*60*1000))
                .signWith(getSecretKey())
                .compact();
    }

    public String getUserName(String token) {
        Claims claim=Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claim.getSubject();
    }
}
