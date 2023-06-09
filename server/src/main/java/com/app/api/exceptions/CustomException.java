package com.app.api.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private HttpStatus statusCode;
    private String message;

    public CustomException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
