package com.example.token.service;

import com.example.token.data.TokenDto;
import com.example.token.domain.ports.api.TokenServicePort;
import com.example.token.domain.ports.api.TokenPersistencePort;

import java.io.IOException;
import java.net.URISyntaxException;

public class TokenServiceImpl implements TokenServicePort {

    private final TokenPersistencePort tokenPersistencePort;

    public TokenServiceImpl(TokenPersistencePort tokenPersistencePort) {
        this.tokenPersistencePort = tokenPersistencePort;
    }

    @Override
    public TokenDto getTokenByUserPassword(String user, String password, String urlToken) throws URISyntaxException, IOException {
        return tokenPersistencePort.getTokenByUserPassword(user, password, urlToken);
    }
}
