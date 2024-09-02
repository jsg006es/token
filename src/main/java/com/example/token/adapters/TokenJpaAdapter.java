package com.example.token.adapters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.example.token.data.TokenDto;
import com.example.token.domain.ports.api.TokenPersistencePort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TokenJpaAdapter implements TokenPersistencePort {

    @Override
    public TokenDto getTokenByUserPassword(String user, String password, String urlToken) throws URISyntaxException, IOException {
        final String responseToken;
        HttpPost httpPost = new HttpPost(urlToken);
        String body = "{ " +
                " \"username\":\"auth-vivelibre\"," +
                " \"password\":\"password\"" +
                "}";
        httpPost.setEntity(new StringEntity(body));
        httpPost.setHeader("Requested-By", "prueba-back");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(httpPost)) {
             responseToken = EntityUtils.toString(response.getEntity());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseToken);
        String token = jsonNode.get("token").asText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

        return new TokenDto(token, LocalDateTime.now().format(formatter));

    }
}
