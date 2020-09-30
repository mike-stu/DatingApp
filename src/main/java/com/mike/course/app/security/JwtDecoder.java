package com.mike.course.app.security;

import com.mike.course.app.constant.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class JwtDecoder {

    public String getEmailFromToken(String token) {
        byte[] signKey = SecurityConstant.JWT_SECRET.getBytes();

        Jws<Claims> parsedToken = Jwts
                .parserBuilder()
                .setSigningKey(signKey)
                .build()
                .parseClaimsJws(token.replace("Bearer", ""));

        return parsedToken.getBody().getSubject();
    }
}
