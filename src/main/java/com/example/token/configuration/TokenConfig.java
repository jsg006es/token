package com.example.token.configuration;

import com.example.token.adapters.TokenJpaAdapter;
import com.example.token.domain.ports.api.TokenServicePort;
import com.example.token.domain.ports.api.TokenPersistencePort;
import com.example.token.service.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

    @Bean
    public TokenPersistencePort tokenPersistence(){
        return new TokenJpaAdapter();
    }

    @Bean
    public TokenServicePort tokenService(){
        return new TokenServiceImpl(tokenPersistence());
    }
}