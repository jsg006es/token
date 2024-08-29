package com.example.token.controller;

import com.example.token.properties.TokenProperties;
import com.example.token.data.TokenDto;
import com.example.token.domain.ports.api.TokenServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class TokenController {

    private final TokenServicePort tokenServicePort;
    private final TokenProperties tokenProperties;

    public TokenController(TokenServicePort tokenServicePort, TokenProperties tokenProperties) {
        this.tokenServicePort = tokenServicePort;
        this.tokenProperties = tokenProperties;
    }

    @GetMapping("/get-token")
    public TokenDto getTokenByUserPassword() throws URISyntaxException, IOException {
        return tokenServicePort.getTokenByUserPassword(tokenProperties.getUsernameToken(), tokenProperties.getPassword());
    }

}
