package com.gerenciador.comics.services.exceptions;

import org.springframework.http.HttpStatus;

public class ServiceException extends Exception {

    private final HttpStatus httpStatus;
    private final String message;

    public ServiceException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
