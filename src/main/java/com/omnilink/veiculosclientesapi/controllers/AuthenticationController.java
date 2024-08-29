package com.omnilink.veiculosclientesapi.controllers;

import com.omnilink.veiculosclientesapi.domain.user.AuthenticationDTO;
import com.omnilink.veiculosclientesapi.domain.user.LoginResponseDTO;
import com.omnilink.veiculosclientesapi.domain.user.User;
import com.omnilink.veiculosclientesapi.infra.security.TokenService;
import com.omnilink.veiculosclientesapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());

        Authentication auth = authenticationManager.authenticate(authenticationToken);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
