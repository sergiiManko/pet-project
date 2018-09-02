package com.petproject.app.payload;

import lombok.Data;

/**
 * @author Sergii Manko
 */
@Data
public class ApiResponse {
    private Boolean success;
    private String message;

    public ApiResponse(final Boolean success, final String message) {
        this.success = success;
        this.message = message;
    }
}
