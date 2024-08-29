package com.omnilink.veiculosclientesapi.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.omnilink.veiculosclientesapi.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        return JWT.create()
                .withIssuer("veiculos-clientes-api")
                .withSubject(user.getLogin())
                .withExpiresAt(genExpirationDate())
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateToken(String token) {
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("veiculos-clientes-api")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
