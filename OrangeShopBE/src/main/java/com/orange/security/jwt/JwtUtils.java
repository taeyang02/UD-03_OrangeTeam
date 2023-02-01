package com.orange.security.jwt;

import com.orange.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${app.token.access.duration}")
    private Long accessTokenDuration;

    @Value("${app.token.refresh.duration}")
    private Long refreshTokenDuration;

    @Value("${app.token.access.key}")
    private String accessTokenKey;

    @Value("${app.token.refresh.key}")
    private String refreshTokenKey;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + accessTokenDuration))
                .signWith(SignatureAlgorithm.HS512, accessTokenKey)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(accessTokenKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String getUserNameFromRefreshToken(String token) {
        return Jwts.parser().setSigningKey(refreshTokenKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(accessTokenKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public boolean validateRefreshToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(refreshTokenKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String generateJwtToken(String userName, long expirationTime, String secret) {
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String generateJwtAccessToken(String userName) {
        return this.generateJwtToken(userName, accessTokenDuration, accessTokenKey);
    }

    public String generateJwtRefreshToken(String userName) {
        return this.generateJwtToken(userName, refreshTokenDuration, refreshTokenKey);
    }
}
