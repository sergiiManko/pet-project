package com.petproject.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sergii Manko
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {
    public AppException(final String message) {
        super(message);
    }

    public AppException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
