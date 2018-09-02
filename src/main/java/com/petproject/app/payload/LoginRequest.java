package com.petproject.app.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Sergii Manko
 */
@Data
public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
}
