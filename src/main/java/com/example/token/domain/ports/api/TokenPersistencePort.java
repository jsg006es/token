package com.example.token.domain.ports.api;

import com.example.token.data.TokenDto;

import java.io.IOException;
import java.net.URISyntaxException;

public interface TokenPersistencePort {

    TokenDto getTokenByUserPassword(String user, String password) throws URISyntaxException, IOException;

}
