package com.example.token.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDto {

    @JsonProperty("auth-vivelibre-token")
    private String token;

    @JsonProperty("date")
    private String dateToken;
}