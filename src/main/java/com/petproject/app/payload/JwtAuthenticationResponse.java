package com.petproject.app.payload;

import lombok.Data;

/**
 * @author Sergii Manko
 */
@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(final String accessToken) {
        this.accessToken = accessToken;
    }
}
